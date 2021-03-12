package com.github.songxzj.common.json;

import com.github.songxzj.common.annotation.GsonExclude;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class WxGsonBuilder {

    private static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping()
                .setExclusionStrategies(new GsonExclusionStrategy())
                .enableComplexMapKeySerialization();
    }


    /**
     * 自定义序列化忽略规则
     */
    private static class GsonExclusionStrategy implements ExclusionStrategy {
        /**
         * 是否跳过属性 不序列化
         * 返回 false 代表 属性要进行序列化
         *
         * @param fieldAttributes
         * @return
         */
        @Override
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            /**
             * 判断当前属性是否带有GsonExclude排除的注解
             * 若有 则 不进行序列化
             * 若无 为 null 则进行序列化
             */
            return fieldAttributes.getAnnotation(GsonExclude.class) != null;
        }


        /**
         * 是否排除对应的类
         * 同时这里也可以 排除 int 类型的属性 不进行序列化
         * 若不排除任何 类  直接 返回false 即可
         *
         * @param aClass
         * @return
         */
        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }

    }


    public static Gson create() {
        return INSTANCE.create();
    }

}
