package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_user database table.
 * 
 */
@Entity
@Table(name="ie_user")

public class IEUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String login;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeTransaction
	@OneToMany(mappedBy="ieUser")
	private List<IETransaction> ieTransactions;

	//bi-directional many-to-one association to IeUserGroup
	@OneToMany(mappedBy="ieUser")
	private List<IEUserGroup> ieUserGroups;

	public IEUser() {
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<IETransaction> getIeTransactions() {
		return this.ieTransactions;
	}

	public void setIeTransactions(List<IETransaction> ieTransactions) {
		this.ieTransactions = ieTransactions;
	}

	public IETransaction addIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().add(ieTransaction);
		ieTransaction.setIeUser(this);

		return ieTransaction;
	}

	public IETransaction removeIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().remove(ieTransaction);
		ieTransaction.setIeUser(null);

		return ieTransaction;
	}

	public List<IEUserGroup> getIeUserGroups() {
		return this.ieUserGroups;
	}

	public void setIeUserGroups(List<IEUserGroup> ieUserGroups) {
		this.ieUserGroups = ieUserGroups;
	}

	public IEUserGroup addIeUserGroup(IEUserGroup ieUserGroup) {
		getIeUserGroups().add(ieUserGroup);
		ieUserGroup.setIeUser(this);

		return ieUserGroup;
	}

	public IEUserGroup removeIeUserGroup(IEUserGroup ieUserGroup) {
		getIeUserGroups().remove(ieUserGroup);
		ieUserGroup.setIeUser(null);

		return ieUserGroup;
	}

}