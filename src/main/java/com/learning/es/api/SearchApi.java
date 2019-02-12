package com.learning.es.api;

import com.alibaba.fastjson.JSONObject;
import com.learning.es.api.model.EsResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
@RestController
@RequestMapping("/search")
@Api("查询_API")
public class SearchApi {
    @Autowired
    private TransportClient client;
    private static final Log log = LogFactory.getLog(SearchApi.class);
    private static final String HIGHLIGHTPREFIX = "<font class='red'>";
    private static final String HIGHLIGHTPOSTFIX = "</font>";

    @GetMapping("/search1")
    @ApiOperation(value = "查询语句(一),should关键字学习",notes = "查询语句(一),should关键字学习")
    public void testSearch1(){
        // 查询条件组装
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.should(QueryBuilders.matchQuery("name","HJJ"));
        query.should(QueryBuilders.matchQuery("sex","女"));
        searchQuery(query,null);
    }

    @GetMapping("/search2")
    @ApiOperation(value = "查询语句(二),must关键字学习",notes = "查询语句(二),must关键字学习")
    public void testSearch2(){
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.should(QueryBuilders.matchQuery("name","HJJ"));
        query.should(QueryBuilders.matchQuery("sex","女"));
        searchQuery(query,null);
    }

    @GetMapping("/search3")
    @ApiOperation(value = "查询语句(三),match_phrase关键字学习",notes = "查询语句(三),match_phrase关键字学习")
    public void testSearch3(){
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.must(QueryBuilders.matchPhraseQuery("book","开发 大全"));
        searchQuery(query,null);
    }

    @GetMapping("/search4")
    @ApiOperation(value = "查询语句(四),高亮显示",notes = "查询语句(四),高亮显示")
    public void testSearch4(){
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags(HIGHLIGHTPREFIX);
        highlightBuilder.postTags(HIGHLIGHTPOSTFIX);
        highlightBuilder.field("开发");
        query.should(QueryBuilders.matchQuery("book","开发"));
        searchQuery(query,highlightBuilder);
    }

    /**
     * 公用查询方法调用
     */
    public void searchQuery(BoolQueryBuilder boolQueryBuilder,HighlightBuilder highlightBuilder) {
        log.info(String.format("查询的query语句: %s",boolQueryBuilder.toString()));
        SearchResponse response = client.prepareSearch("megacorp")
                .setTypes("employee")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder)
                .highlighter(highlightBuilder)
                .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))
                .get();
        SearchHits searchHits = response.getHits();

        List<EsResponse> results = new ArrayList<>((int) searchHits.totalHits);
        searchHits.forEach(hit -> {
            //模型转换
            log.info(hit.getSourceAsString());
            EsResponse esResponse = JSONObject.parseObject(hit.getSourceAsString()).toJavaObject(EsResponse.class);
            log.info(String.format("返回结果实体信息:%s",esResponse.toString()));
            //高亮处理
            String content = Arrays.toString(hit.getHighlightFields().get("开发").fragments());
            log.info(String.format("高亮返回内容:%s",content));
            results.add(esResponse);
        });
    }
}
