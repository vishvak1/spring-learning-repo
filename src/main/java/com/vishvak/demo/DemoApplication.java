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
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO){
		int id = 1;

		System.out.println("Deleting instructor for id: "+id+"...");

		appDAO.delete(id);
	}

	private void findInstructor(AppDAO appDAO){
		int id = 1;

		Instructor instructor = appDAO.findById(id);

		System.out.println("Instructor found:\t"+instructor.toString());

		System.out.println("Instructor detail for "+id+":\t"+instructor.getInstructorDetail().toString());
	}

	private void CreateInstructor(AppDAO appDAO){
		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("https://youtube.com/channel/madhupatel","Guitar");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving Instructor...");

		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
