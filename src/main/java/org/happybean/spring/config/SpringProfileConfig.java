package org.happybean.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
@Configuration
@PropertySource(value = {"classpath:mysql.properties"})
public class SpringProfileConfig implements EmbeddedValueResolverAware {

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
}
