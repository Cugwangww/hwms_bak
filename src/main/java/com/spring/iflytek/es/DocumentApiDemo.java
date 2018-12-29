package com.spring.iflytek.es;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.elasticsearch.action.index.IndexRequest;
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
@RequestMapping("/")
@Api("文档索引")
public class DocumentApiDemo {

    @Autowired
    private TransportClient transportClient;

    @GetMapping("/inserDoc")
    @ApiOperation(value = "新增文档",notes = "新增文档")
    public void insertDoc(){
        IndexRequest request = new IndexRequest(
                "megacorp",   //索引
                "employee",    // mapping type
                "1");       //文档id
        JSONObject jo = new JSONObject();
        jo.put("name","ceshi");
        jo.put("age",23);
        jo.put("sex","男");
        request.source(jo.toJSONString(), XContentType.JSON);
    }
}
