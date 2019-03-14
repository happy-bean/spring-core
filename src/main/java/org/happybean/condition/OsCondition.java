package org.happybean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wgt
 * @date 2019-03-14
 * @description 条件注册：条件规则 必须实现 org.springframework.context.annotation.Condition
 **/
public class OsCondition implements Condition {

    /**
     * 满足操作系统是mac时才会创建 name为乔布斯的bean
     *
     * @param conditionContext      上下文（环境）
     * @param annotatedTypeMetadata 注解信息
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取环境信息
        Environment environment = conditionContext.getEnvironment();
        //获取操作系统信息
        String osName = environment.getProperty("os.name");
        if (osName.equals("Mac OS X")) {
            return true;
        }
        return false;
    }
}
