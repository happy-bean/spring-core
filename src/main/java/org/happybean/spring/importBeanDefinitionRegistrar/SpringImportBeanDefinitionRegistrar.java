package org.happybean.spring.importBeanDefinitionRegistrar;

import org.happybean.bean.Animal;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wgt
 * @date 2019-03-15
 * @description 自定义注册
 **/
public class SpringImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param annotationMetadata     当前类注解信息
     * @param beanDefinitionRegistry beanDefinition 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //判断是否存在 name为animal 的bean
        if (!beanDefinitionRegistry.containsBeanDefinition("animal")) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Animal.class);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition("animal", beanDefinition);
        }
    }
}
