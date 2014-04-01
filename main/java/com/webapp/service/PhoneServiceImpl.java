package com.webapp.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.EntityDao;
import com.webapp.models.Phone;

@Service("phoneService")
@Transactional(value=TxType.REQUIRED)
public class PhoneServiceImpl implements EntityService<Phone>{

	@Autowired
	private EntityDao<Phone> phoneDao;
	
	@Override
	public void createEntity(Phone entity) {
		phoneDao.createEntity(entity);
	}

	@Override
	public List<Phone> getListEntity() {
		return phoneDao.listEntity();
	}

	@Override
	public Phone readEntityById(int id) {
		return phoneDao.getEntity(id);
	}

	@Override
	public void updateEntity(Phone entity) {
		phoneDao.updateEntity(entity);
	}

	@Override
	public void deleteEntity(Phone entity) {
		phoneDao.deleteEntity(entity);
	}
}
