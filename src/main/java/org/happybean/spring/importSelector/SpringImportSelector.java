package org.happybean.spring.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wgt
 * @date 2019-03-15
 * @description 自定义注册选择器
 **/
public class SpringImportSelector implements ImportSelector {

    /**
     * 注册的所有类
     *
     * @param annotationMetadata 当前类注解的信息 例如：@Import
     * @return 所有需要注册到容器的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] className = {"org.happybean.bean.Animal"};
        return className;
    }
}
