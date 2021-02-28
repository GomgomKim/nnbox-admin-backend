package com.nnbox.admin;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nnbox.admin.common.utils.Messages;

@SpringBootApplication
public class AppApplication {
    @Autowired
    Messages messages;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println("Starting..");
        System.out.println(messages.get("application.name"));
    }
}
