package org.happybean.spring.profile;

/**
 * @author wgt
 * @date 2019-03-18
 * @description spring提供Profile可以根据当前环境，动态激活一系列组件
 * 例如：开发、测试、生产环境。数据源
 **/
public interface Profiles {

    /**
     * 根据环境动态加载组件：@Profile
     * */
    void profile();
}
