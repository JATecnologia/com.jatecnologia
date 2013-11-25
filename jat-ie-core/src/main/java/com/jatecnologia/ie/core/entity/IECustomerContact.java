package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ie_customer_contact database table.
 * 
 */
@Entity
@Table(name="ie_customer_contact")
@NamedQuery(name="IECustomerContact.findAll", query="SELECT i FROM IECustomerContact i")
public class IECustomerContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="contry_code")
	private String contryCode;

	private String ddd;

	private String operator;

	private String telephone;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IeCutomer
	@ManyToOne
	@JoinColumn(name="customer_id", insertable = false, updatable = false)
	private IECutomer ieCutomer;

	public IECustomerContact() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContryCode() {
		return this.contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public IECutomer getIeCutomer() {
		return this.ieCutomer;
	}

	public void setIeCutomer(IECutomer ieCutomer) {
		this.ieCutomer = ieCutomer;
	}

}