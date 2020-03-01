package com.mt.metro.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JsonFilter {

    /**
     * json选择已有的属性返回
     *
     * @param entity
     * @param filter
     * @return
     */
    public static Object getJsonFilter(Object entity, SimplePropertyPreFilter filter) {
        Object o = JSONObject.parse(JSONObject.toJSONString(entity, filter,SerializerFeature.WriteMapNullValue));
        return o;
    }


    /**
     * json返回除了这些属性返回的
     *
     * @param entity
     * @param filter
     * @return
     */
    public static Object getJsonPreFilter(Object entity, PropertyFilter filter) {
        Object o = JSONObject.parse(JSONObject.toJSONString(entity, filter, SerializerFeature.WriteMapNullValue));
        return o;
    }

}
