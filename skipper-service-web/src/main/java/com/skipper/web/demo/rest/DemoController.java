package com.skipper.web.demo.rest;

import com.skipper.api.demo.DemoService;
import com.skipper.api.demo.model.dto.DemoDTO;
import com.skipper.helper.enums.ApiResponseCode;
import com.skipper.helper.exception.SkipperException;
import com.skipper.helper.model.Result;
import com.skipper.web.demo.model.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @ApiOperation(value = "根据id获取demo详情", notes = "get方法，id获取详情")//其中有个tags参数，用于生产另外的组显示
    Result<DemoVO> getDemoById(@RequestParam(value = "demoId") Long demoId) throws SkipperException {
        SkipperException.isNull(demoId, "demoId不能为空");
        DemoDTO demoDTO = demoService.getDemoById(demoId);
        if (demoDTO == null) {
            SkipperException.fail(ApiResponseCode.DATA_NOT_EXIST, "demo数据不存在");
        }
        DemoVO demoVO = new DemoVO();
        BeanUtils.copyProperties(demoDTO, demoVO);
        return Result.createSuccess(demoVO,"获取demo详情成功");
    }

    @RequestMapping(path = "/{demoId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据id删除demo数据", notes = "该删除是软删除")
    Result<Boolean> deleteDemoById(@RequestParam(value = "demoeId") Long demoId) throws SkipperException {
        SkipperException.isNull(demoId, "demoId不能为空");
        return Result.createSuccess(demoService.deleteDemo(demoId), "删除demo数据成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增demo数据",notes = "返回的是新增的demo的id")
    Result<Long> addDemo(@RequestBody DemoVO demoVO) {
        DemoDTO demoDTO = new DemoDTO();
        BeanUtils.copyProperties(demoVO, demoDTO);
        return Result.createSuccess(demoService.addDemo(demoDTO),"新增demo数据成功");
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "更新demo数据", notes = "true表示更新成功，false表示更新失败")
    Result<Boolean> updateDemo(@RequestBody DemoVO demoVO) {
        DemoDTO demoDTO = new DemoDTO();
        BeanUtils.copyProperties(demoVO, demoDTO);
        return Result.createSuccess(demoService.updateDemo(demoDTO),"更新demo数据成功");
    }

}
