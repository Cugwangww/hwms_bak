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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wwwang7
 * @Date 2019/1/2 14:45
 */
@RestController
@RequestMapping("/search")
@Api("查询_API")
public class SearchApi {
    @Autowired
    private TransportClient client;
    private static final Log log = LogFactory.getLog(SearchApi.class);

    @GetMapping("/search1")
    @ApiOperation(value = "查询语句(一),match关键字学习",notes = "查询语句(一),match关键字学习")
    public void testSearch1(){
        // 查询条件组装
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.should(QueryBuilders.matchQuery("name","王维维"));
        searchQuery(query);
    }

    @GetMapping("/search2")
    @ApiOperation(value = "查询语句(二)",notes = "查询语句(二)")
    public void testSearch2(){
        // 查询条件组装
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.filter(QueryBuilders.regexpQuery("age",""));
        query.should(QueryBuilders.matchQuery("name","王维维"));
        searchQuery(query);
    }

    /**
     * 公用查询方法调用
     */
    public void searchQuery(BoolQueryBuilder query) {
        log.info(String.format("查询的dsl语句:%s",query.toString()));
        SearchResponse response = client.prepareSearch("megacorp")
                .setTypes("employee")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(query)
                .get();
        SearchHits searchHits = response.getHits();
        List<EsResponse> results = new ArrayList<>((int) searchHits.totalHits);
        searchHits.forEach(hit -> {
            //模型转换
            EsResponse esResponse = JSONObject.parseObject(hit.getSourceAsString()).toJavaObject(EsResponse.class);
            results.add(esResponse);
        });
        results.forEach(re -> {
            log.info(String.format("返回结果实体信息:%s",re.toString()));
        });
    }
}
