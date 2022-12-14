package com.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbDay17Application {
	
	//Ambil directory Project
	public static String NewDir = System.getProperty("user.dir") + "/uploadDir/";

	public static void main(String[] args) {
		SpringApplication.run(SbDay17Application.class, args);
	//Create directory
	//new File("D:\\Gitsource\\Batch2").mkdir();
	new File(NewDir).mkdir();
	//System.out.println(System.getProperty("user.dir"));
	}

}
