package com.example.appsCasaBackend.lista.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.lista.datasource")
@EnableJpaRepositories(basePackages = "com.example.appsCasaBackend.lista.repositories", entityManagerFactoryRef = "listaEntityManagerFactory", transactionManagerRef = "listaTransactionManager")
@EnableTransactionManagement
public class ListaBDConfiguration extends HikariConfig{

	protected Map<String, Object> jpaProperties() {
	    Map<String, Object> props = new HashMap<>();
	    props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
	    props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
	    return props;
	}
	
	@Bean(name = "listaDataSource")
	@Primary
	public DataSource listaDataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource(this);
		return hikariDataSource;
	}

	@Bean(name = "listaEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean listaEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(listaDataSource())
				.packages("com.example.appsCasaBackend.lista.model")
				.persistenceUnit("listaPersistenceUnit")
				.properties(jpaProperties())
				.build();
	}

	@Bean(name = "listaTransactionManager")
	@Primary
	public JpaTransactionManager listaTransactionManager(@Qualifier("listaEntityManagerFactory") final EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
