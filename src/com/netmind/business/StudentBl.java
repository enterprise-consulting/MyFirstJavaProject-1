package com.netmind.business;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class StudentBl {

	public boolean add(Student student) {
		StudentDao studentDao = new StudentDao();

		student.setAge(calculateAge(student.getDateOfBirth()));

		return studentDao.add(student);
	}

	public int calculateAge(Date birthDate) {

		Period age = Period.between(birthDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

		return age.getYears();
	}

}
