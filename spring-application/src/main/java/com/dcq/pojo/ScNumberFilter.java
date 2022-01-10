package com.dcq.pojo;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigDecimal;
import java.math.MathContext;

public class ScNumberFilter implements ValueFilter {

    @Override
    public Object process(Object o, String s, Object o1) {
        if (o1 instanceof String){
            boolean matches = ((String) o1).matches("^(\\S)+E\\+(\\d)+$");
            if (matches){
                o1 = new BigDecimal((String) o1, MathContext.DECIMAL64).toPlainString();
            }
        }
        return o1;
    }
}
