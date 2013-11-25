package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_group database table.
 * 
 */
@Entity
@Table(name="ie_group")
@NamedQuery(name="IEGroup.findAll", query="SELECT i FROM IEGroup i")
public class IEGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeUserGroup
	@OneToMany(mappedBy="ieGroup")
	private List<IEUserGroup> ieUserGroups;

	public IEGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<IEUserGroup> getIeUserGroups() {
		return this.ieUserGroups;
	}

	public void setIeUserGroups(List<IEUserGroup> ieUserGroups) {
		this.ieUserGroups = ieUserGroups;
	}

	public IEUserGroup addIeUserGroup(IEUserGroup ieUserGroup) {
		getIeUserGroups().add(ieUserGroup);
		ieUserGroup.setIeGroup(this);

		return ieUserGroup;
	}

	public IEUserGroup removeIeUserGroup(IEUserGroup ieUserGroup) {
		getIeUserGroups().remove(ieUserGroup);
		ieUserGroup.setIeGroup(null);

		return ieUserGroup;
	}

}