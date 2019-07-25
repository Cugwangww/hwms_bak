package com.learning.es.executor;

import com.learning.es.config.executor.ExecutorConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wwwang7
 * @Date 2019/5/13 16:11
 */
@RestController
@RequestMapping(value = "excutorTest", produces = "application/json")
@Api("线程池API")
public class ExcutorController {

    private static Log logger = LogFactory.getLog(ExcutorController.class);

    @ApiOperation(value = "GET请求传递参数的方式(一)", notes = "GET请求传递参数的方式(一)")
    @GetMapping(value = "/getMethod1")
    public void getMethod1(@RequestParam("param") String param) {
        logger.info(String.format("GET请求传递参数的方式,传入参数:%s",param));
        logger.info(String.format("*************GET(一)****************"));
    }

    @ApiOperation(value = "GET请求传递参数的方式(二)", notes = "GET请求传递参数的方式(二)")
    @GetMapping(value = "/getMethod2/{param}")
    public void getMethod2(@PathVariable("param") String param) {
        logger.info(String.format("GET请求传递参数的方式,传入参数:%s",param));
        logger.info(String.format("*************GET(二)****************"));
    }
}
