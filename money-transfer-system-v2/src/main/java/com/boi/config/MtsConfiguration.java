package com.boi.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.boi")
public class MtsConfiguration {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:55000/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgrespw");
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(10);
        return dataSource;
    }

}
