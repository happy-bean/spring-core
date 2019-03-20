package org.happybean.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:mysql.properties"})
@Import(org.happybean.service.UserServiceImpl.class)
public class SpringProfileConfig implements EmbeddedValueResolverAware {

    //@EnableTransactionManagement 开启基于注解的事务管理，还必须声明事务管理器

    @Value("${db.user}")
    private String user;

    private StringValueResolver stringValueResolver;

    //spring提供@Profile可以根据当前环境，动态激活一系列组件
    //指定在某个环境下激活组件 默认是default @Profile("default")
    //@Profile("dev") 也可以写在类上 没有标注的类 任何环境都能注册
    @Profile("dev")
    @Bean
    public DataSource devDataSource(@Value("${db.pwd}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(pwd);
        String jdbcUrl = stringValueResolver.resolveStringValue("${db.jdbcUrl}");
        source.setJdbcUrl(jdbcUrl);
        source.setDriverClass("com.mysql.jdbc.Driver");
        return source;
    }

    @Profile("pro")
    @Bean
    public DataSource proDataSource(@Value("${db.pwd}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(pwd);
        String jdbcUrl = stringValueResolver.resolveStringValue("${db.jdbcUrl}");
        source.setJdbcUrl(jdbcUrl);
        source.setDriverClass("com.mysql.jdbc.Driver");
        return source;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }

    //spring对@Configuration的类会特殊处理，多次调用@bean标识的方法也是从容器中直接获取

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource devDataSource) {
        JdbcTemplate template = new JdbcTemplate(devDataSource);
        return template;
    }

    //声明注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(DataSource devDataSource) {
        return new DataSourceTransactionManager(devDataSource);
    }
}
