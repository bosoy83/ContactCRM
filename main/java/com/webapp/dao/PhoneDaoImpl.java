package com.webapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.models.Phone;

@Repository("phoneDao")
public class PhoneDaoImpl implements EntityDao<Phone>{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEntity(Phone emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public Phone getEntity(int id) {
		return (Phone) sessionFactory.getCurrentSession().get(Phone.class, id);
	}

	@Override
	public List<Phone> listEntity() {
		@SuppressWarnings("unchecked")
		List<Phone> listPhone=sessionFactory.getCurrentSession().createCriteria(Phone.class).list();
		return listPhone;
	}

	@Override
	public void deleteEntity(Phone emp) {
		sessionFactory.getCurrentSession().delete(emp);
		
	}

	@Override
	public void updateEntity(Phone emp) {
		sessionFactory.getCurrentSession().update(emp);	
	}
	
	

}
