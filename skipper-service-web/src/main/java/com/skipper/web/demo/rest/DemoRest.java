package com.skipper.web.demo.rest;

import com.skipper.web.demo.model.vo.DemoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shoujian on 2017/5/6.
 */
@RestController
@RequestMapping(value = "/demo")
public interface DemoRest {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取demo详情",notes = "get方法，id获取详情")
    DemoVO getDemoById();

}
