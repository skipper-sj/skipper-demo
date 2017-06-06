package com.skipper.dao;

import com.skipper.dao.entity.SkipperDemo;

public interface SkipperDemoMapper {
    int deleteByPrimaryKey(Long demoId);

    int insert(SkipperDemo record);

    int insertSelective(SkipperDemo record);

    SkipperDemo selectByPrimaryKey(Long demoId);

    int updateByPrimaryKeySelective(SkipperDemo record);

    int updateByPrimaryKey(SkipperDemo record);
}