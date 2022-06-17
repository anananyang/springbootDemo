package com.anyang.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@MapperScan(basePackages = "com.anyang.demo.dao")
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resource = patternResolver.getResources("classpath:mapper/**/*.xml");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 设置 xml 映射文件位置
        factoryBean.setMapperLocations(resource);
        factoryBean.setConfigLocation(patternResolver.getResource("classpath:mybatis-config.xml"));
        // 设置外部数据源，本项目使用 hikari 数据库连接池
        factoryBean.setDataSource(dataSource());
        factoryBean.setTypeAliasesPackage("com.anyang.demo.domain");  // 类型别名
        factoryBean.setVfs(SpringBootVFS.class); // Sets the SpringBootVFS class into SqlSessionFactoryBean

        return factoryBean.getObject();
    }


    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://pdnas.local:3306/test");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("root");
        config.setMinimumIdle(8);
        config.setConnectionTimeout(30000);
        config.setMaximumPoolSize(64);
        config.setConnectionInitSql("set collation_connection=utf8mb4_general_ci");

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty(" serverTimezone", "Asia/Shanghai");
        config.addDataSourceProperty(" useUnicode", "true");
        config.addDataSourceProperty(" characterEncoding", "UTF-8");
        config.addDataSourceProperty(" autoReconnect", "true");
        config.addDataSourceProperty(" allowMultiQueries", "true");
        config.addDataSourceProperty(" zeroDateTimeBehavior", "convertToNull");
        config.addDataSourceProperty(" useSSL", "false");

        return new HikariDataSource(config);
    }


}
