package com.skipper.api.common.model;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.Min;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * 分页入参通用实体类
 * <p>
 * Created by shoujian on 2017/5/8.
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = -3504379837441464197L;

    @Min(1)
    @DefaultValue("1")
    @QueryParam(value = "pageIndex")
    @ApiParam(value = "分页参数：当前分页页数")
    private Integer pageIndex;

    @Min(1)
    @DefaultValue("14")
    @QueryParam(value = "pageSize")
    @ApiParam(value = "分页参数：当前分页大小")
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
