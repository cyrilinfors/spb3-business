package com.cmr.dev.business.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableJpaAuditing
@EntityScan("com.cmr.dev.business.entity")
@EnableJpaRepositories("com.cmr.dev.business.dao")
@ComponentScan(basePackages = { "com.cmr.dev.business.*" })
public class Spb3BusinessConfig {

	@Bean(value = "spb3-modelmapper")
	@Scope(value = "singleton")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean(value = "BCRYPT_ENCODER")
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
