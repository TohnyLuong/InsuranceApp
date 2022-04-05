package com.synex.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class AppConfig {

//	@Bean
//	public BCryptPasswordEncoder bCryptpeasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;

	}
	
	
	@Bean
	public DataSource dataSource() {
		var dataSource = new DriverManagerDataSource();
		
//		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        dataSource.setUsername("SCOTT");
//        dataSource.setPassword("TIGER");
        
		
		 //Class.forName("com.mysql.cj.jdbc.Driver"); // loading the driver class from particular jar file.
        //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","mysql");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/InsuranceGateway");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
        return dataSource;
	}
	
	@Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.synex.domain");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(jpaProperties());
        
        return entityManagerFactory;
    }
	
	//Oracle SQL PLUS
//    public Properties jpaProperties(){
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.dilect", "org.hibernate.dialect.Oracle10gDialect");
//        jpaProperties.setProperty("hibernate.show_sql", "true");
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // hbm = hibernate mapping, ddl = data definition language
//        
//        return jpaProperties;
//    }
    
    //MySQL
	public Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		//jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		jpaProperties.setProperty("hibernate.show_SQL", "true");
		return jpaProperties;
	}
	
}
