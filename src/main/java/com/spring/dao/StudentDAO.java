package com.spring.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
