package onlineshop;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Basic(optional=false)
	private int address_Id;
	
	@Basic(optional=false)
	private String street;
	
	@Basic(optional=false)
	@Column(columnDefinition="CHAR(2) NOT NULL")
	private String country;
	
	@Basic(optional=false)
	@Column(name="POSTAL_CODE",length=10)
	private String postalCode;
	
	@Basic(optional=false)
	private String city;
	
	@Basic(optional=false)
	@Column(columnDefinition="TINYINT UNSIGNED NOT NULL")
	private int deleted;
	
	@OneToMany(mappedBy="deliveryAddress", orphanRemoval=true)
	private List<Customer> del_customers = new ArrayList<Customer>();
	
	@OneToMany(mappedBy="invoiceAddress",orphanRemoval=true)
	private List<Customer> inv_customers = new ArrayList<Customer>();

	public List<Customer> getDel_customers() {
		return del_customers;
	}

	public void setDel_customers(List<Customer> del_customers) {
		this.del_customers = del_customers;
	}

	public List<Customer> getInv_customers() {
		return inv_customers;
	}

	public void setInv_customers(List<Customer> inv_customers) {
		this.inv_customers = inv_customers;
	}
	
	/**
	 * @param id_adresse the id_adresse to set
	 */
	public void setAddress_Id(int id_adresse) {
		this.address_Id = id_adresse;
	}

	/**
	 * @return the id_adresse
	 */
	public int getAddress_Id() {
		return address_Id;
	}

	/**
	 * @param strasse the strasse to set
	 */
	public void setStreet(String strasse) {
		this.street = strasse;
	}

	/**
	 * @return the strasse
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param lkz the lkz to set
	 */
	public void setCountry(String lkz) {
		this.country = lkz;
	}

	/**
	 * @return the lkz
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param plz the plz to set
	 */
	public void setPostalCode(String plz) {
		this.postalCode = plz;
	}

	/**
	 * @return the plz
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param ort the ort to set
	 */
	public void setCity(String ort) {
		this.city = ort;
	}

	/**
	 * @return the ort
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the deleted
	 */
	public int getDeleted() {
		return deleted;
	}


}
