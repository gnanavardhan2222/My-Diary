package com.twg.spring.mydiary.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twg.spring.mydiary.entities.User;

@Component
public class UserDaoInterfaceImpl implements UserDaoInterface {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly = false)
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Transactional(readOnly = false)
	public void update(User user) {
		hibernateTemplate.update(user);
		
	}

	@Transactional(readOnly = false)
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(User.class);
	}

	public User findByUsername(String username) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		
		criteria.add(Restrictions.eq("username", username));

		User user = null;
		
		try {
			user=(User)hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
