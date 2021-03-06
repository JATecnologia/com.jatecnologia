package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ie_user_group database table.
 * 
 */
@Embeddable
public class IEUserGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="group_id", insertable=false, updatable=false)
	private int groupId;

	@Column(name="user_id", insertable=false, updatable=false)
	private int userId;

	public IEUserGroupPK() {
	}
	public int getGroupId() {
		return this.groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IEUserGroupPK)) {
			return false;
		}
		IEUserGroupPK castOther = (IEUserGroupPK)other;
		return 
			(this.groupId == castOther.groupId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId;
		hash = hash * prime + this.userId;
		
		return hash;
	}
}