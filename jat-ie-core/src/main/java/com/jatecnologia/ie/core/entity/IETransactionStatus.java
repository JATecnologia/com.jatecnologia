package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_transaction_status database table.
 * 
 */
@Entity
@Table(name="ie_transaction_status")

public class IETransactionStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String status;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeTransaction
	@OneToMany(mappedBy="ieTransactionStatus")
	private List<IETransaction> ieTransactions;

	public IETransactionStatus() {
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		ieTransaction.setIeTransactionStatus(this);

		return ieTransaction;
	}

	public IETransaction removeIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().remove(ieTransaction);
		ieTransaction.setIeTransactionStatus(null);

		return ieTransaction;
	}

}