package com.spring.dao;

import java.sql.DriverManager;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Attendance;
import com.spring.model.Student;

@Repository
@Transactional
public class StudentDAO {

	@Autowired
	EntityManager entityManager;
	
	private Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	public int save(Student student) {
		int status = (int) getSession().save(student);
		System.err.println(status);
		return status;
	}
	
	public List<Student> getAll(){
		String sql = "from Student";
        List<Student> students = getSession().createQuery(sql).list();
        return students;
	}
	public List<Attendance> getAllAttendance(){
		String sql = "from Attendance";
        List<Attendance> attendances = getSession().createQuery(sql).list();
        return attendances;
	}
	
	
	public int saveAttendance(Attendance attendance) {
		int status = (int) getSession().save(attendance);
		System.err.println(status);
		return status;
	}
	
}
