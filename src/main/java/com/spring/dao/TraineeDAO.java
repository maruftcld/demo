package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Attendance;
import com.spring.model.Trainee;
import com.spring.model.Trainee;

@Repository
@Transactional
public class TraineeDAO {

	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    public Trainee save(Trainee p){
    	getSession().save(p);
    	getSession().flush();
        return p;
    }
    

    public List<Trainee> getAll(){
    	String sql = "from Trainee";
        List<Trainee> Trainees = getSession().createQuery(sql).list();
        return Trainees;
    }

    public Trainee getTraineeById(int pid) {
        String sql = "from Trainee where id = '" + pid + "'";
        List<Trainee> empList = getSession().createQuery(sql).list();
        return empList.get(0);

    }

    public Trainee update(Trainee p) {
       // String hql = "update Trainee set name = '"+p.getName()+"', quantity = '"+p.getQuantity()+"', price = '"+p.getPrice()+"'  where id = '"+p.getId()+"'";
        Query q = getSession().createQuery("");
        q.executeUpdate();
        getSession().flush();
        return p;
    }


    public Trainee delete(int id) {
    	String sql = "delete from Trainee where id = '"+id+"'";
        int delete = getSession().createQuery(sql).executeUpdate();
        return null;
    }
	
	
}
