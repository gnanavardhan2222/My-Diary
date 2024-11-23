package com.twg.spring.mydiary.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twg.spring.mydiary.dao.EntryDaoInterface;
import com.twg.spring.mydiary.entities.Entry;


@Component
public class EntryBusinessInterfaceImpl implements EntryBusinessInterface {
	
	@Autowired
	private  EntryDaoInterface entryDaoInterface;

	public void save(Entry entry) {
		entryDaoInterface.save(entry);
	}

	public void update(Entry entry) {
		entryDaoInterface.update(entry);
	
	}

	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);
	}

	public Entry findById(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findById(id);
	}

	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return entryDaoInterface.findAll();
	}

	public List<Entry> findByUserid(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.findByUserid(id);
	}

}
