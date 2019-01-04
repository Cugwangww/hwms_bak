package com.learning.es.api;

import com.alibaba.fastjson.JSONObject;
import com.learning.es.config.util.RandomGUID;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
    public void insertDoc(@RequestParam(name = "name")String name,@RequestParam(name = "age")int age,@RequestParam(name = "level")int level,
                          @RequestParam(name = "sex")String sex,@RequestParam(name = "book")String book,@RequestParam(name = "job")String job){
        JSONObject jo = new JSONObject();
        jo.put("name",name);
        jo.put("age",age);
        jo.put("sex",sex);
        jo.put("book",book);
        jo.put("level",level);
        jo.put("job",job);
        IndexResponse indexResponse = null;
        try {
            indexResponse = client.prepareIndex("megacorp","employee", RandomGUID.getGuid())
                        .setSource(jo.toJSONString(),XContentType.JSON)
                        .get();
        } catch(ElasticsearchException e) {
            log.error("索引异常", e);
        }
    }

    @GetMapping("/getDoc")
    @ApiOperation(value = "索引文档",notes = "索引文档")
    public String getDoc(@RequestParam(name = "id")String id){
        GetResponse response = client.prepareGet("megacorp", "employee", id).get();
        String result = "";
        if(response!=null){
            result = response.getSourceAsString();
            log.info(String.format("获取文档结果:%s",result));
        }
        return result;
    }
}
