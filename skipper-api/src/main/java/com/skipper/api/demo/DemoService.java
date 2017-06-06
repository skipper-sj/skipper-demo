package com.skipper.api.demo;

import com.skipper.api.demo.model.dto.DemoDTO;
import com.skipper.helper.exception.SkipperException;

import java.util.List;

/**
 * api层接口，以dubbo方式暴露
 * <p>
 * Created by shoujian on 2017/5/8.
 */
public interface DemoService {

    /**
     * 根据demoid获取demo详情
     *
     * @param demoId 入参
     * @return 返回值
     */
    DemoDTO getDemoById(Long demoId) throws SkipperException;

    /**
     * 根据id列表获取demo列表信息
     *
     * @param demoIds id列表
     * @return demo列表
     */
    List<DemoDTO> getDemoListByIds(List<Long> demoIds);

    /**
     * 新增demo数据
     *
     * @param demoDTO demo实体
     * @return demoid
     */
    Long addDemo(DemoDTO demoDTO);

    /**
     * 更新demo数据
     *
     * @param demoDTO demo实体
     * @return 是否成功（0 不成功 1 成功）
     */
    Boolean updateDemo(DemoDTO demoDTO);

    /**
     * 删除demo数据
     *
     * @param demoId id数据
     * @return 是否成功（0 不成功 1 成功）
     */
    Boolean deleteDemo(Long demoId);


}
