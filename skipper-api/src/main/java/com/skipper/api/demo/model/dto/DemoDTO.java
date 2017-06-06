package com.skipper.api.demo.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * service层dto实体
 * <p>
 * Created by shoujian on 2017/6/5.
 */
public class DemoDTO implements Serializable {

    private static final long serialVersionUID = 6637352096789691559L;

    /**
     * demo表主键
     */
    private Long demoId;

    /**
     * demo名称
     */
    private String demoName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志位0未删除 1已删除
     */
    private Integer isDeleted;

    public Long getDemoId() {
        return demoId;
    }

    public void setDemoId(Long demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName == null ? null : demoName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}
