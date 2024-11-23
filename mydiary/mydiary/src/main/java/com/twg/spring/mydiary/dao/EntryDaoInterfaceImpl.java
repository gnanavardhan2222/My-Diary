package com.twg.spring.mydiary.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twg.spring.mydiary.entities.Entry;

@Component
public class EntryDaoInterfaceImpl implements EntryDaoInterface {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly = false)
	public void save(Entry entry) {
		hibernateTemplate.save(entry);

	}

	@Transactional(readOnly = false)
	public void update(Entry entry) {
		hibernateTemplate.update(entry);

	}

	@Transactional(readOnly = false)
	public void delete(Entry entry) {
		hibernateTemplate.delete(entry);

	}

	public Entry findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Entry.class, id);
	}

	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Entry.class);
	}

	public List<Entry> findByUserid(int id) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Entry.class);
		criteria.add(Restrictions.eq("userid", id));
		
		List<Entry> entries=(List<Entry>)hibernateTemplate.findByCriteria(criteria);
		
		
		return entries;
	}

}
