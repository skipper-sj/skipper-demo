package com.skipper.web.demo.rest;

import com.skipper.api.demo.DemoService;
import com.skipper.api.demo.model.dto.DemoDTO;
import com.skipper.helper.enums.ApiResponseCode;
import com.skipper.helper.exception.SkipperException;
import com.skipper.web.demo.model.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by shoujian on 2017/6/2.
 */
@RestController
@RequestMapping(value = "/demo")
@Api(value = "例子代码controller")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(path = "/{demoId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取demo详情", notes = "get方法，id获取详情")
    DemoVO getDemoById(@RequestParam(value = "name") Long demoId) throws SkipperException{
        SkipperException.isNull(demoId,"demoId不能为空");
        DemoDTO demoDTO = demoService.getDemoById(demoId);
        if (demoDTO != null) {
            SkipperException.fail(ApiResponseCode.DATA_NOT_EXIST,"demo数据不存在");
        }
        DemoVO demoVO = new DemoVO();
        BeanUtils.copyProperties(demoDTO, demoVO);
        return demoVO;
    }
}
