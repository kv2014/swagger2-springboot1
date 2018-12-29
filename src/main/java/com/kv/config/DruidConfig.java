package com.kv.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ClassName: DruidConfig <br/>
 * Function: druid需要的配置类. <br/>
 * date: 2018年7月16日 下午4:43:58 <br/>
 * 一种方式：采用注解的方式获取 @value("${变量的key值}") 获取application配置文件中的变量。</br>
 * 另一种方式：凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时， 获取到系统环境变量和application配置文件中的变量。
 * 
 */
@Configuration
public class DruidConfig {

    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${spring.datasource.url}")
    private String              url;

    @Value("${spring.datasource.username}")
    private String              username;

    @Value("${spring.datasource.password}")
    private String              password;

    @Value("${spring.datasource.driverClassName}")
    private String              driverClass;

    @Value("${spring.datasource.druid.initialSize}")
    private int                 initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int                 minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int                 maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private long                maxWait;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private long                timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private long                minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String              validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean             testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean             testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean             testOnReturn;

    @Value("${spring.datasource.druid.poolPreparedStatements}")
    private boolean             poolPreparedStatements;

    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int                 maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.druid.filters}")
    private String              filters;

    @Value("${spring.datasource.druid.connectionProperties}")
    private String              connectionProperties;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClass);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }


}
