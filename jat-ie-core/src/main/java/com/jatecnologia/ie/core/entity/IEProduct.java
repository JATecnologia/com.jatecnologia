package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_product database table.
 * 
 */
@Entity
@Table(name="ie_product")
public class IEProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte actived;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeTransaction
	@OneToMany(mappedBy="ieProduct")
	private List<IETransaction> ieTransactions;

	public IEProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActived() {
		return this.actived;
	}

	public void setActived(byte actived) {
		this.actived = actived;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<IETransaction> getIeTransactions() {
		return this.ieTransactions;
	}

	public void setIeTransactions(List<IETransaction> ieTransactions) {
		this.ieTransactions = ieTransactions;
	}

	public IETransaction addIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().add(ieTransaction);
		ieTransaction.setIeProduct(this);

		return ieTransaction;
	}

	public IETransaction removeIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().remove(ieTransaction);
		ieTransaction.setIeProduct(null);

		return ieTransaction;
	}

}