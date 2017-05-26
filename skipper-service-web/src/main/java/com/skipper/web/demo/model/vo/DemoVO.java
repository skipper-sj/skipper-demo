package com.skipper.web.demo.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skipper.api.common.helper.serialize.DoubleToLongDeserialize;
import com.skipper.api.common.helper.serialize.LongToDoubleSerialize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * demo实体类
 * <p>
 * Created by shoujian on 2017/5/26.
 */
@Api("demo实体类")
public class DemoVO {

    @ApiModelProperty(value = "demoId")
    @NotNull(message = "demoId不能为空")
    private Long demoId;

    @ApiModelProperty(value = "demo名称")
    @NotNull(message = "demo名称不能为空")
    private String demoName;

    @ApiModelProperty(value = "价格")
    @JsonSerialize(using = LongToDoubleSerialize.class)//序列化，将数据库的long型转换成真是的数值
    @JsonDeserialize(using = DoubleToLongDeserialize.class)//反序列化，将页面上的double类型的数据转换成数据库的long型
    private Long price;

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
        this.demoName = demoName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
