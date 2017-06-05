package com.skipper.web.demo.rest;

import com.skipper.web.demo.model.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shoujian on 2017/6/2.
 */
@RestController
@RequestMapping(value = "/demo")
@Api(value = "例子代码controller")
public class DemoController {


    @RequestMapping(path = "/{demoId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取demo详情", notes = "get方法，id获取详情")
    DemoVO getDemoById(Long demoId) {
        System.out.println("ss");
        return null;
    }
}
