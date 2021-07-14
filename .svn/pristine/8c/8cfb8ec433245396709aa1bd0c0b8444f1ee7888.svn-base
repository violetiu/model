package org.violetime.model.annnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 容器配置注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelContainerConfig {
    /**
     * 给定配置的json文件,目前支持相对路径，即项目根目录下，例如：WEB-INF/classes/org/violetime/extensions/java/k-means.json
     * @return
     */
    String config();


}
