package com.example.todolisttailwind.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class TodolistTailwindBackendApplication {

	//deleteMapping을 이용하기 위해서 추가
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	public static void main(String[] args) {
		SpringApplication.run(TodolistTailwindBackendApplication.class, args);
	}

}
