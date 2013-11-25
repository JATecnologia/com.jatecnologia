package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_language database table.
 * 
 */
@Entity
@Table(name="ie_language")
public class IELanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeTransaction
	@OneToMany(mappedBy="ieLanguage")
	private List<IETransaction> ieTransactions;

	public IELanguage() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		ieTransaction.setIeLanguage(this);

		return ieTransaction;
	}

	public IETransaction removeIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().remove(ieTransaction);
		ieTransaction.setIeLanguage(null);

		return ieTransaction;
	}

}