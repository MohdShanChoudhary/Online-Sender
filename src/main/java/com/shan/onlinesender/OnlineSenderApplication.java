package com.shan.onlinesender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlineSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSenderApplication.class, args);
		System.out.println("\n========================================");
		System.out.println("🚀 Online Sender is running!");
		System.out.println("📋 Open: http://localhost:8080");
		System.out.println("❤️  Made by Shan");
		System.out.println("========================================\n");
	}
}