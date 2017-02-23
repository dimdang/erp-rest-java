package com.erp.configurations;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by DANG on 22-Feb-17.
 */

@EnableAutoConfiguration
@MapperScan("com.erp.repositories")
@Configuration
public class MybatisConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
