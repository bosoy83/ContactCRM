package com.webapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PhoneType")
public class PhoneType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="type")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int type;
	
	@Column(name="typeName")
	private String typeName;
	
	@Column(name="remark")
	private String remark;
	
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	@OneToMany(mappedBy="typer", fetch=FetchType.LAZY)
	private List<Phone> phone;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + type;
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
		PhoneType other = (PhoneType) obj;
		if (type != other.type)
			return false;
		return true;
	}
	
}
