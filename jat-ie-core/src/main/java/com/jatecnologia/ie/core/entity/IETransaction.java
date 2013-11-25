package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ie_transaction database table.
 * 
 */
@Entity
@Table(name="ie_transaction")
public class IETransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date appointment;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="closing_date")
	private Date closingDate;

	private String contact;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_contact")
	private Date lastContact;

	private String locality;

	@Lob
	private String observation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date visit;

	//bi-directional many-to-one association to IeCutomer
	@ManyToOne
	@JoinColumn(name="customer_id", insertable = false, updatable = false)
	private IECutomer ieCutomer;

	//bi-directional many-to-one association to IeUser
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private IEUser ieUser;

	//bi-directional many-to-one association to IeProduct
	@ManyToOne
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private IEProduct ieProduct;

	//bi-directional many-to-one association to IeTransactionStatus
	@ManyToOne
	@JoinColumn(name="transaction_status", insertable = false, updatable = false)
	private IETransactionStatus ieTransactionStatus;

	//bi-directional many-to-one association to IeLanguage
	@ManyToOne
	@JoinColumn(name="language_code")
	private IELanguage ieLanguage;

	public IETransaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Date appointment) {
		this.appointment = appointment;
	}

	public Date getClosingDate() {
		return this.closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getLastContact() {
		return this.lastContact;
	}

	public void setLastContact(Date lastContact) {
		this.lastContact = lastContact;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getScheduled() {
		return this.scheduled;
	}

	public void setScheduled(Date scheduled) {
		this.scheduled = scheduled;
	}

	public Date getVisit() {
		return this.visit;
	}

	public void setVisit(Date visit) {
		this.visit = visit;
	}

	public IECutomer getIeCutomer() {
		return this.ieCutomer;
	}

	public void setIeCutomer(IECutomer ieCutomer) {
		this.ieCutomer = ieCutomer;
	}

	public IEUser getIeUser() {
		return this.ieUser;
	}

	public void setIeUser(IEUser ieUser) {
		this.ieUser = ieUser;
	}

	public IEProduct getIeProduct() {
		return this.ieProduct;
	}

	public void setIeProduct(IEProduct ieProduct) {
		this.ieProduct = ieProduct;
	}

	public IETransactionStatus getIeTransactionStatus() {
		return this.ieTransactionStatus;
	}

	public void setIeTransactionStatus(IETransactionStatus ieTransactionStatus) {
		this.ieTransactionStatus = ieTransactionStatus;
	}

	public IELanguage getIeLanguage() {
		return this.ieLanguage;
	}

	public void setIeLanguage(IELanguage ieLanguage) {
		this.ieLanguage = ieLanguage;
	}

}