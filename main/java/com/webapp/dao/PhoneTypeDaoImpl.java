package com.webapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.models.PhoneType;

@Repository("phoneTypeDao")
public class PhoneTypeDaoImpl implements EntityDao<PhoneType>{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEntity(PhoneType emp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PhoneType getEntity(int id) {
		return (PhoneType) sessionFactory.getCurrentSession().get(PhoneType.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhoneType> listEntity() {
		List<PhoneType> listPhoneType=sessionFactory.getCurrentSession().createCriteria(PhoneType.class).list();
		return listPhoneType;
	}

	@Override
	public void deleteEntity(PhoneType emp) {
		throw new UnsupportedOperationException();	
	}

	@Override
	public void updateEntity(PhoneType emp) {
		throw new UnsupportedOperationException();
	}

}
