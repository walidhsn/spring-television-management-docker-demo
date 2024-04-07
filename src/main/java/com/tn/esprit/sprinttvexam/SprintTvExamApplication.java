package com.tn.esprit.sprinttvexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SprintTvExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintTvExamApplication.class, args);
	}

}
