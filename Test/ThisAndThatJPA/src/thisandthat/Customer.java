package thisandthat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private int customer_Id;
	
	@Basic(optional=false)
	@Column(nullable=false)
	private String firstname;

	@Basic(optional=false)
	@Column(nullable=false)
	private String lastname;
	
	private String salutation;
	
	@Column(name="CUSTOMER_TYPE", columnDefinition = "VARCHAR(15) NOT NULL")
	private String type;
	
	
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getType() {
		return type;
	}
	public void setType(String customer_Type) {
		this.type = customer_Type;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	private Boolean deleted;

}
