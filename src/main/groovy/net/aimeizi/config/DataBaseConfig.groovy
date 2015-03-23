package net.aimeizi.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource

/**
 * Created by Administrator on 2015/3/22 0022.
 */

/**
 * 自定义数据库连接配置类 该类不是必须的。用于自定义配置数据源信息
 */
//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = "classpath:application.properties")
class DataBaseConfig {

    @Value('${spring.datasource.driverClassName}')
    String driverClassName
    @Value('${spring.datasource.url}')
    String url
    @Value('${spring.datasource.username}')
    String username
    @Value('${spring.datasource.password}')
    String password

    @Value('${hibernate.hbm2ddl.auto}')
    String auto_create

    @Value('${hibernate.show_sql}')
    String show_sql

    @Value('${hibernate.format_sql}')
    String format_sql

    @Value('${hibernate.dialect}')
    String dialect

    @Value('${hibernate.packagesToScan}')
    String packagesToScan


    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url: url,username: username,password: password)
        dataSource.driverClassName = driverClassName
        return dataSource
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean()
        entityManagerFactory.dataSource = dataSource()
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter()
        entityManagerFactory.jpaVendorAdapter = vendorAdapter
        entityManagerFactory.jpaProperties = jpaProperties()
        entityManagerFactory.packagesToScan = packagesToScan
        return entityManagerFactory
    }

    @Bean
    JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().getObject()
        return transactionManager
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties jpaProperties(){
        Properties properties = new Properties()
        properties.put("hibernate.hbm2ddl.auto",auto_create)
        properties.put("hibernate.show_sql",show_sql)
        properties.put("hibernate.format_sql",format_sql)
        properties.put("hibernate.dialect",dialect)
    }

}
