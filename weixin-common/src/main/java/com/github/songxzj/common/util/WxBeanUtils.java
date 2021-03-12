package com.github.songxzj.common.util;

import com.github.songxzj.common.annotation.Required;
import com.github.songxzj.common.bean.BaseV3Inner;
import com.github.songxzj.common.exception.WxErrorException;
import com.github.songxzj.common.exception.WxErrorExceptionFactor;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * bean操作的一些工具类
 */
@Slf4j
public class WxBeanUtils {

    /**
     * 检查bean里标记为@Required的field是否为空，为空则抛异常
     *
     * @param bean 要检查的bean对象
     */
    public static void checkRequiredFields(Object bean) throws WxErrorException {
        List<String> requiredFields = Lists.newArrayList();

        List<Field> fields = Lists.newArrayList(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
        for (Field field : fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.isAnnotationPresent(Required.class)) {
                    // 两种情况，一种是值为null，
                    // 另外一种情况是类型为字符串，但是字符串内容为空的，都认为是没有提供值
                    boolean isRequiredMissing = field.get(bean) == null
                            || (field.get(bean) instanceof String
                            && StringUtils.isBlank(field.get(bean).toString())
                    );
                    if (isRequiredMissing) {
                        requiredFields.add(field.getName());
                    }
                }
                field.setAccessible(isAccessible);
            } catch (SecurityException | IllegalArgumentException
                    | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }

        if (!requiredFields.isEmpty()) {
            String msg = "必填字段 " + requiredFields + " 必须提供值";
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, msg);
        }
    }


    /**
     * 检查bean里标记为@Required的field是否为空，为空则抛异常 （v3）
     *
     * @param bean
     * @throws WxErrorException
     */
    public static void checkRequiredV3Fields(Object bean) throws WxErrorException {
        List<String> requiredFields = Lists.newArrayList();
        requiredFields.addAll(getRequiredV3Fields(bean));

        if (!requiredFields.isEmpty()) {
            String msg = "必填字段 " + requiredFields + " 必须提供值";
            throw new WxErrorException(WxErrorExceptionFactor.INVALID_PARAMETER_CODE, msg);
        }

    }

    /**
     * v3
     *
     * @param bean
     * @return
     */
    private static List<String> getRequiredV3Fields(Object bean) {
        List<String> requiredFields = Lists.newArrayList();

        List<Field> fields = Lists.newArrayList(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
        for (Field field : fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.isAnnotationPresent(Required.class)) {
                    // 一种是值为null，
                    // 另外一种情况是类型为字符串，但是字符串内容为空的，都认为是没有提供值
                    boolean isRequiredMissing = field.get(bean) == null
                            || (field.get(bean) instanceof String
                            && StringUtils.isBlank(field.get(bean).toString()));
                    if (isRequiredMissing) {
                        requiredFields.add(field.getName());
                    }

                    // 另外一种情况是v3内部类
                    if (field.get(bean) instanceof BaseV3Inner) {
                        requiredFields.addAll(getRequiredV3Fields(field.get(bean)));
                    }
                }
                field.setAccessible(isAccessible);
            } catch (SecurityException | IllegalArgumentException
                    | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
        return requiredFields;
    }


    /**
     * 检查bean 所有字段是否为null
     *
     * @param bean
     * @return
     */
    public static boolean isAllFieldNull(Object bean) {

        List<Field> fields = Lists.newArrayList(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));

        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);

                // 一种是值为null，
                // 另外一种情况是类型为字符串，但是字符串内容为空的，都认为是没有提供值
                boolean isRequiredMissing = field.get(bean) == null
                        || (field.get(bean) instanceof String
                        && StringUtils.isBlank(field.get(bean).toString()));

                field.setAccessible(isAccessible);

                if (!isRequiredMissing) {
                    return false;
                }
            } catch (SecurityException | IllegalArgumentException
                    | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
        return true;
    }

}
