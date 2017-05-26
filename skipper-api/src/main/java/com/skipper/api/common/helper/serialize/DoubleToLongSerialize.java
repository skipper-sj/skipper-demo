package com.skipper.api.common.helper.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * 反序列化数据，将double类型的数据转成期望的long型
 * <p>
 * <p>
 * Created by shoujian on 2017/5/26.
 */
public class DoubleToLongSerialize extends JsonDeserializer<Long> {

    //将
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Long temp = null;
        try {
            Double doubleTemp = 0d;
            if (StringUtils.isNotBlank(p.getText())) {
                doubleTemp = Double.parseDouble(p.getText());
            }
            temp = Math.round(doubleTemp * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
