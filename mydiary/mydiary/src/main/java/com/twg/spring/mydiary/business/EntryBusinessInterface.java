package com.twg.spring.mydiary.business;

import java.util.List;

import com.twg.spring.mydiary.entities.Entry;

public interface EntryBusinessInterface {

	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findById(int id);
	public List<Entry> findAll();
	public List<Entry> findByUserid(int id);
	
}
