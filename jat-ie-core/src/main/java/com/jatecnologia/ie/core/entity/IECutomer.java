package com.jatecnologia.ie.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ie_cutomer database table.
 * 
 */
@Entity
@Table(name="ie_cutomer")
public class IECutomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte actived;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birth_date")
	private Date birthDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="jat_cutomercol")
	private String jatCutomercol;

	private String surname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to IECustomerAddress
	@OneToMany(mappedBy="ieCutomer")
	private List<IECustomerAddress> ieCustomerAddresses;

	//bi-directional many-to-one association to IeCustomerContact
	@OneToMany(mappedBy="ieCutomer")
	private List<IECustomerContact> ieCustomerContacts;

	//bi-directional many-to-one association to IeTransaction
	@OneToMany(mappedBy="ieCutomer")
	private List<IETransaction> ieTransactions;

	public IECutomer() {
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

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJatCutomercol() {
		return this.jatCutomercol;
	}

	public void setJatCutomercol(String jatCutomercol) {
		this.jatCutomercol = jatCutomercol;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public List<IECustomerAddress> getIeCustomerAddresses() {
		return this.ieCustomerAddresses;
	}

	public void setIeCustomerAddresses(List<IECustomerAddress> ieCustomerAddresses) {
		this.ieCustomerAddresses = ieCustomerAddresses;
	}

	public IECustomerAddress addIeCustomerAddress(IECustomerAddress ieCustomerAddress) {
		getIeCustomerAddresses().add(ieCustomerAddress);
		ieCustomerAddress.setIeCutomer(this);

		return ieCustomerAddress;
	}

	public IECustomerAddress removeIeCustomerAddress(IECustomerAddress ieCustomerAddress) {
		getIeCustomerAddresses().remove(ieCustomerAddress);
		ieCustomerAddress.setIeCutomer(null);

		return ieCustomerAddress;
	}

	public List<IECustomerContact> getIeCustomerContacts() {
		return this.ieCustomerContacts;
	}

	public void setIeCustomerContacts(List<IECustomerContact> ieCustomerContacts) {
		this.ieCustomerContacts = ieCustomerContacts;
	}

	public IECustomerContact addIeCustomerContact(IECustomerContact ieCustomerContact) {
		getIeCustomerContacts().add(ieCustomerContact);
		ieCustomerContact.setIeCutomer(this);

		return ieCustomerContact;
	}

	public IECustomerContact removeIeCustomerContact(IECustomerContact ieCustomerContact) {
		getIeCustomerContacts().remove(ieCustomerContact);
		ieCustomerContact.setIeCutomer(null);

		return ieCustomerContact;
	}

	public List<IETransaction> getIeTransactions() {
		return this.ieTransactions;
	}

	public void setIeTransactions(List<IETransaction> ieTransactions) {
		this.ieTransactions = ieTransactions;
	}

	public IETransaction addIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().add(ieTransaction);
		ieTransaction.setIeCutomer(this);

		return ieTransaction;
	}

	public IETransaction removeIeTransaction(IETransaction ieTransaction) {
		getIeTransactions().remove(ieTransaction);
		ieTransaction.setIeCutomer(null);

		return ieTransaction;
	}

}