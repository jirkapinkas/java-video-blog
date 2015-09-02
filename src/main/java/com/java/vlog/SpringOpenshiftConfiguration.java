package com.java.vlog;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Profile("openshift")
@Configuration
public class SpringOpenshiftConfiguration {

	@Bean
	public DataSource dataSource() {
		String url = "jdbc:postgresql://" + System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT") + "/"
				+ System.getenv("OPENSHIFT_APP_NAME");
		String username = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName("org.postgresql.Driver");
		config.setMaximumPoolSize(5);
		return new HikariDataSource(config);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.show_sql", "false");
		jpaProperties.put("hibernate.default_batch_fetch_size", 10);
		entityManagerFactory.setJpaProperties(jpaProperties);
		entityManagerFactory.setPackagesToScan("com.java.vlog.entity");
		entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		return entityManagerFactory;
	}

}
