package com.webapp.dao;

import java.util.List;

public interface EntityDao<T> {
	
	public void createEntity(T emp);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public T getEntity(int id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<T> listEntity();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void deleteEntity(T emp);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void updateEntity(T emp);

}
