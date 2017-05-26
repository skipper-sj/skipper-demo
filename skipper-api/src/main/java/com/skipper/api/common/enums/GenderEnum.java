package com.skipper.api.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 性别枚举
 * <p>
 * Created by shoujian on 2017/5/8.
 */
public enum GenderEnum {

    UNKNOWN(0, "未知"), MAN(1, "先生"), WOMAN(2, "女士");

    private Integer value;
    private String chinese;

    private GenderEnum(Integer value, String chinese) {
        this.value = value;
        this.chinese = chinese;
    }

    public String getChinese() {
        return this.chinese;
    }

    public Integer getValue() {
        return this.value;
    }

    public static GenderEnum getInstanceByChinese(String chinese) {
        if (StringUtils.isNotBlank(chinese)) {
            GenderEnum[] instArray = GenderEnum.values();
            for (GenderEnum instance : instArray) {
                if (instance.getChinese().equals(chinese)) {
                    return instance;
                }
            }

        }
        return null;
    }

    public static GenderEnum getInstance(Integer value) {
        if (value != null) {
            GenderEnum[] instArray = GenderEnum.values();
            for (GenderEnum instance : instArray) {
                if (instance.getValue().equals(value)) {
                    return instance;
                }
            }

        }
        return null;
    }

}
