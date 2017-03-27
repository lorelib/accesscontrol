package com.lorelib.accesscontrol.infrastructure.helpers.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtil extends JSONObject {

    private static final long serialVersionUID = 1L;

    /**
     * 空值和null值均产生出json数据
     */
    public static String toJsonString(Object obj) {
        return JSONObject.toJSONString(obj,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.SkipTransientField,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * 空值不输出
     * @param obj
     * @return
     */
    public static String noneBlank(Object obj) {
        return JSONObject.toJSONString(obj, SerializerFeature.NotWriteDefaultValue, SerializerFeature.SkipTransientField);
    }
}
