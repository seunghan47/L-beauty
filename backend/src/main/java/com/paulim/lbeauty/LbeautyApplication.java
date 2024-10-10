package com.paulim.lbeauty;

import com.paulim.lbeauty.service.NewItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LbeautyApplication {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("java.class.path"));

		SpringApplication.run(LbeautyApplication.class, args);
	}
}
