package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ie_user_group database table.
 * 
 */
@Entity
@Table(name="ie_user_group")

public class IEUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IEUserGroupPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeUser
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private IEUser ieUser;

	//bi-directional many-to-one association to IeGroup
	@ManyToOne
	@JoinColumn(name="group_id", insertable = false, updatable = false)
	private IEGroup ieGroup;

	public IEUserGroup() {
	}

	public IEUserGroupPK getId() {
		return this.id;
	}

	public void setId(IEUserGroupPK id) {
		this.id = id;
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

	public IEUser getIeUser() {
		return this.ieUser;
	}

	public void setIeUser(IEUser ieUser) {
		this.ieUser = ieUser;
	}

	public IEGroup getIeGroup() {
		return this.ieGroup;
	}

	public void setIeGroup(IEGroup ieGroup) {
		this.ieGroup = ieGroup;
	}

}