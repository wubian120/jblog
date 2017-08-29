package com.brianwu.jblog.dao.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DBLocalConfig.PACKAGE, sqlSessionFactoryRef = "localSqlSessionFactory")
public class DBLocalConfig {

    static final String PACKAGE = "com.brianwu.jblog.dao.basic";
    static final String MAPPER_LOCATION = "classpath*:mapper/*.xml";


    @Value("${local.url}")
    private String url;
    @Value("${local.user}")
    private String user;
    @Value("${local.password}")
    private String password;
    @Value("${local.driverClass}")
    private String driverClass;

    @Bean(name="localDataSource")
    @Primary
    public DataSource localDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name="localTransactionManager")
    @Primary
    public DataSourceTransactionManager localTransactionManager(){
        return new DataSourceTransactionManager(localDataSource());
    }

    @Bean(name="localSqlSessionFactory")
    @Primary
    public SqlSessionFactory localSqlSessionFactory(@Qualifier("localDataSource")DataSource localDataSource)
            throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(localDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DBLocalConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();


    }







}
