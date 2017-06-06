package com.skipper.service.demo.service.impl;

import com.skipper.api.demo.DemoService;
import com.skipper.api.demo.model.dto.DemoDTO;
import com.skipper.dao.SkipperDemoMapper;
import com.skipper.dao.entity.SkipperDemo;
import com.skipper.helper.enums.ApiResponseCode;
import com.skipper.helper.exception.SkipperException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * demo实现类，主要涉及业务代码
 * <p>
 * Created by shoujian on 2017/5/8.
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private SkipperDemoMapper skipperDemoMapper;//对应的mapper方法

    @Override
    public DemoDTO getDemoById(Long demoId) {
        SkipperDemo skipperDemo = skipperDemoMapper.selectByPrimaryKey(demoId);
        if (skipperDemo == null) {
            SkipperException.fail(ApiResponseCode.DATA_NOT_EXIST, "你要获取的demo数据不存在");
        }
        DemoDTO demoDTO = new DemoDTO();
        BeanUtils.copyProperties(skipperDemo, demoDTO);
        return demoDTO;
    }

    @Override
    public List<DemoDTO> getDemoListByIds(List<Long> demoIds) {
        return null;
    }

    @Override
    public Long addDemo(DemoDTO demoDTO) {
        SkipperDemo demo = new SkipperDemo();
        BeanUtils.copyProperties(demoDTO, demo);
        Integer rst = skipperDemoMapper.insert(demo);
        if (rst == 0) {
            SkipperException.fail(ApiResponseCode.DB_ERROR,"新增失败");
        }
        return demo.getDemoId();
    }

    @Override
    public Boolean updateDemo(DemoDTO demoDTO) {
        SkipperDemo demo = new SkipperDemo();
        BeanUtils.copyProperties(demoDTO, demo);
        Integer rst = skipperDemoMapper.updateByPrimaryKeySelective(demo);
        if (rst == 0) {
            SkipperException.fail(ApiResponseCode.DB_ERROR, "更新失败");
        }
        return true;
    }

    @Override
    public Boolean deleteDemo(Long demoId) {
        Integer rst = skipperDemoMapper.deleteByPrimaryKey(demoId);
        if (rst == 0) {
            SkipperException.fail(ApiResponseCode.DB_ERROR, "删除失败");
        }
        return true;
    }
}
