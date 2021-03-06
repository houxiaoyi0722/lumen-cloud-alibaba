package com.lumen.common.annotations;

import java.lang.annotation.*;

/**
 * key:value转换设定注解
 * @author xiaoy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface DictionaryTran {
    /**
     * 组id
     */
    String groupId();

    /**
     * 目标字段名称,为空则默认该字段
     */
    String valueTargetField() default "";
}
