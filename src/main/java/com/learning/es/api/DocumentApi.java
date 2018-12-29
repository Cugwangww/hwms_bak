package com.learning.es.api;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wwwang7
 * @Date 2018/12/29 11:27
 */
@RestController
@RequestMapping("/doc")
@Api("文档_API")
public class DocumentApi {

    @Autowired
    private TransportClient client;
    private static final Log log = LogFactory.getLog(DocumentApi.class);

    @GetMapping("/inserDoc")
    @ApiOperation(value = "创建文档",notes = "创建文档")
    public void insertDoc(){
        JSONObject jo = new JSONObject();
        jo.put("name","测试");
        jo.put("age",23);
        jo.put("sex","男");
        IndexResponse indexResponse = null;
        try {
            indexResponse = client.prepareIndex("megacorp","employee","1")
                        .setSource(jo.toJSONString(),XContentType.JSON)
                        .get();
        } catch(ElasticsearchException e) {
            log.error("索引异常", e);
        }
    }

    @GetMapping("/getDoc")
    @ApiOperation(value = "索引文档",notes = "索引文档")
    public void getDoc(){
        GetResponse response = client.prepareGet("megacorp", "employee", "1").get();
        if(response!=null){
            String result = response.getSourceAsString();
            log.info(String.format("获取文档结果:%s",result));
        }
    }
}
