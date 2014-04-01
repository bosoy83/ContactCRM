package com.webapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Phone")
public class Phone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public PhoneType getTyper() {
		return typer;
	}
	public void setTyper(PhoneType typer) {
		this.typer = typer;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	
	@Column(name="phoneNumber",nullable=false)
	private String phoneNumber;
	
	@Column(name="phoneType", nullable=false,insertable=false, updatable=false )
	private int phoneType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="client_id",unique=true, nullable=false,insertable=false, updatable=false )
	private int client_id;
	
	@OneToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="phoneType")
	private PhoneType typer;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNumber=" + phoneNumber
				+ ", phoneType=" + phoneType + ", description=" + description
				+ ", client_id=" + client_id + "]";
	}


}
