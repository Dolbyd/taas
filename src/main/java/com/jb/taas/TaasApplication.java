package com.jb.taas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "com.jb.taas" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.jb.taas.clr.off.*"))
@EnableScheduling
public class TaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaasApplication.class, args);
	}

}
