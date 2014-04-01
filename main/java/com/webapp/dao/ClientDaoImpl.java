package com.webapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.models.Client;

@Repository("clientDao")
public class ClientDaoImpl implements EntityDao<Client>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEntity(Client emp) {
		sessionFactory.getCurrentSession().save(emp);
		
	}

	@Override
	public Client getEntity(int id) {
		return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
	}

	@Override
	public List<Client> listEntity() {
		@SuppressWarnings("unchecked")
		List<Client> listClient=sessionFactory.getCurrentSession().createCriteria(Client.class).list();
		return listClient;
	}

	@Override
	public void deleteEntity(Client emp) {
		sessionFactory.getCurrentSession().delete(emp);
	}

	@Override
	public void updateEntity(Client emp) {
		sessionFactory.getCurrentSession().update(emp);	
	}

	

}
