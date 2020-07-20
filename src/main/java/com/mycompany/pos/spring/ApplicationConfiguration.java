package com.mycompany.pos.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.mycompany.pos.repository")
@EnableJpaAuditing
@EnableTransactionManagement
public class ApplicationConfiguration {
}
