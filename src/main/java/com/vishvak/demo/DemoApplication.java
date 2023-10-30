package com.vishvak.demo;

import com.vishvak.demo.dao.AppDAO;
import com.vishvak.demo.entity.Instructor;
import com.vishvak.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			findInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO){
		int id = 2;

		System.out.println("Deleting instructor Detail for id: "+id+"...");

		appDAO.delete(id);
	}

	private void findInstructorDetail(AppDAO appDAO){
		int id = 2;

		InstructorDetail instructorDetail = appDAO.findById(id);

		System.out.println("InstructorDetail found:\t"+instructorDetail.toString());

		System.out.println("Instructor for "+id+":\t"+instructorDetail.getInstructor().toString());
	}
}
