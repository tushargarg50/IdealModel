package com.tg.javabrainsunit.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@EnableJpaRepositories(basePackages = "com.tg.javabrainsunit.repo")
@EnableTransactionManagement
@EnableCaching
public class JavabrainsUnitConfig {

//	@Autowired
//	private Environment env;
//	
//	@Autowired
//	private DataSource datasource;
	
}
