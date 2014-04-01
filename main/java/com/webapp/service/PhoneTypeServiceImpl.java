package com.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.EntityDao;
import com.webapp.models.PhoneType;

@Service("phoneTypeService")
@Transactional
public class PhoneTypeServiceImpl implements EntityService<PhoneType>{

	@Autowired
	EntityDao<PhoneType> phoneTypeDao;
	
	@Override
	public void createEntity(PhoneType entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PhoneType> getListEntity() {
		return phoneTypeDao.listEntity();
	}

	@Override
	public PhoneType readEntityById(int id) {
		return phoneTypeDao.getEntity(id);
	}

	@Override
	public void updateEntity(PhoneType entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteEntity(PhoneType entity) {
		throw new UnsupportedOperationException();
	}

}
