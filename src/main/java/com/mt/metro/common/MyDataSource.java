package com.mt.metro.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyDataSource {

    // 主库数据源
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.master1")
    public DataSource masterDataSource1() {
        return DataSourceBuilder.create().build();
    }

    // 主库数据源
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    // 从库数据源
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    // 数据源路由
    @Bean
    public DataSource dynamicDatasource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(MultipleDataSourceHelper.MASTER, masterDataSource());
        dataSourceMap.put(MultipleDataSourceHelper.SLAVE, slaveDataSource());

        dataSourceMap.put(MultipleDataSourceHelper.MASTER1, masterDataSource1());

        DynamicDataSource dds = new DynamicDataSource();
        dds.setTargetDataSources(dataSourceMap);
        dds.setDefaultTargetDataSource(masterDataSource1());
        return dds;
    }
}