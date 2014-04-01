package com.webapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.EntityDao;
import com.webapp.models.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements EntityService<Client>{
	
	@Autowired
	private EntityDao<Client> clientDao;
	
	@Override
	public void createEntity(Client entity) {
		clientDao.createEntity(entity);
	}

	@Override
	public List<Client> getListEntity() {
		return clientDao.listEntity();
	}

	@Override
	public Client readEntityById(int id) {
		return clientDao.getEntity(id);
	}

	@Override
	public void updateEntity(Client entity) {
		clientDao.updateEntity(entity);
	}

	@Override
	public void deleteEntity(Client entity) {
		clientDao.deleteEntity(entity);
	}

}
