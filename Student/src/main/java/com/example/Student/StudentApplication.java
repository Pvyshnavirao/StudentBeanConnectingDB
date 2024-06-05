package com.example.Student;

import com.example.Student.Service.StudentService;
import com.example.Student.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentApplication {



	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		Student s = context.getBean(Student.class);

		s.setSid(193);
		s.setSname("vysh");
		s.setMarks(4);



		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s );
		List<Student> students= service.getStudents();
		System.out.println(students);

		service.delete(s);

		List<Student> students1= service.getStudents();
		System.out.println(students1);

	}


}
