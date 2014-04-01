package com.webapp.service;


import java.util.List;

public interface EntityService<T> {
	
	public	void createEntity(T entity);
	
	public	List<T> getListEntity();
	
	public	T readEntityById(int id);

	public	void updateEntity(T entity);

	public	void deleteEntity(T entity);

}
