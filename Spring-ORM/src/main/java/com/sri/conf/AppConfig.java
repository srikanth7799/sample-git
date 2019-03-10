package com.sri.conf;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.sri")
@EnableTransactionManagement
public class AppConfig{
	
	@Bean
	public DataSource ds()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("tiger");
		return ds;
	}
	@Bean 
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean lf=new LocalSessionFactoryBean();
		lf.setAnnotatedClasses(com.sri.entity.Emp1.class);
		lf.setDataSource(ds());
	
		lf.setHibernateProperties(hp());
		return lf;
		
	}
	 @Bean
	    public Properties hp()
	    {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.show_sql", true);
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        
	        return properties;
	    }
	
	
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate ht(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
    
        hibernateTemplate.setSessionFactory(sessionFactory);
        return hibernateTemplate;
    }
    	
} 
