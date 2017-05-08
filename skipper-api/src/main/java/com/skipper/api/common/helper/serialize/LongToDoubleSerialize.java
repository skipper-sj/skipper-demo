package com.skipper.api.common.helper.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 将数据库long型数据转换成Double（数据库存储的是实际数值乘以1000，返回除以1000）
 *
 * Created by shoujian on 2017/5/8.
 */
public class LongToDoubleSerialize extends JsonSerializer<Long> {

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        Double doubleTemp = value.doubleValue() / 10000;
        //两位有效数字
        String strTemp = String.format("%.2f", doubleTemp);
        gen.writeString(strTemp);
    }

}
