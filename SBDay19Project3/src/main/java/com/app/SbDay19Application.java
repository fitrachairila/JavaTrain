package com.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbDay19Application {

	public static String NewDir = System.getProperty("user.dir") + "/uploadDir/";
	public static void main(String[] args) {
		SpringApplication.run(SbDay19Application.class, args);
		new File(NewDir).mkdir();
	}

}
