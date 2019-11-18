package com.learning.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wwwang7
 * @Date 2018/12/29 14:32
 */
@RestController
@RequestMapping("/index")
@Api("索引_API")
public class IndexApi {

    @Autowired
    private TransportClient client;
    private static final Log log = LogFactory.getLog(IndexApi.class);

    @GetMapping("/insertIndex")
    @ApiOperation(value = "创建索引",notes = "创建索引")
    public void insertIndex(){
        try{
            // 1、创建 创建索引request
            CreateIndexRequest request = new CreateIndexRequest("megacorp");
            // 2、设置索引的settings
            request.settings(Settings.builder().put("index.number_of_shards", 2) // 分片数
                    .put("index.number_of_replicas", 0) // 副本数
            );
            // 3、设置索引的mappings
            request.mapping("employee",
                    "  {\n" +
                            "    \"employee\": {\n" +
                            "      \"properties\": {\n" +
                            "        \"message\": {\n" +
                            "          \"type\": \"text\"\n" +
                            "        }\n" +
                            "      }\n" +
                            "    }\n" +
                            "  }",
                    XContentType.JSON);
            // 4、 设置索引的别名
            //request.alias(new Alias("aaa"));
            // 5、 发送请求 这里和RESTful风格不同
            CreateIndexResponse createIndexResponse = client.admin().indices()
                    .create(request).get();
            // 6、处理响应
            boolean acknowledged = createIndexResponse.isAcknowledged();
            System.out.println("acknowledged = " + acknowledged);
        }catch (Exception e){
            log.error("创建索引失败",e);
        }
    }
}
