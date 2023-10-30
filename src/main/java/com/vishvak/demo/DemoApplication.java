package com.vishvak.demo;

import com.vishvak.demo.dao.AppDAO;
import com.vishvak.demo.entity.Course;
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
			CreateCoursesWithInstructor(appDAO);
		};
	}

	private void CreateCoursesWithInstructor(AppDAO appDAO){
		Instructor instructor = new Instructor("Susan", "Parker", "susan.parker@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("https://youtube.com/channel/susan-parker","Video games");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("Guitar Pinball Masterclass");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		// Since CascadeType.PERSIST is being used in both Course and Instructor classes that means that whenever either course object or
		// instructor object is saved the other associated class will also be persisted. Here in this case Instructor is being saved and
		// since it was annotated with cascade persist the associated course objects are also persisted and saved in the database.

		System.out.println("Saving Instructor..."+instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
