package com.nyh.ex06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.util.Arrays;

@SpringBootApplication
public class Ex06Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext
				= SpringApplication.run(Ex06Application.class, args);

//		Arrays.stream(applicationContext.getBeanDefinitionNames())
//				.forEach(System.out::println);

	}



}
