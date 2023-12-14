package onlineshop;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "customerGenerator")
	@TableGenerator(name = "customerGenerator",table = "ID_GEN",pkColumnName = "GEN_KEY",valueColumnName = "GEN_VALUE",pkColumnValue = "CUSTOMER_ID",allocationSize = 1)
	@Column(name="CUSTOMER_ID")
	private int customer_Id;
	
	private String salutation;

	@Basic(optional=false)	
	private String lastname;
	
	@Basic(optional=false)		
	private String firstname;

	@Basic(optional=false)
	@Column(name="CUSTOMER_TYPE",length = 25)
	private String customerType;

	@Basic(optional=false)
	@Column(name="DELETED", columnDefinition="TINYINT UNSIGNED NOT NULL")
	private int deleted;

	@ManyToOne(optional=true, cascade= {CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="DELIVERY_ADDRESS_ID")
	private Address deliveryAddress;
	
	@ManyToOne(optional=true,cascade=CascadeType.PERSIST)
	@JoinColumn(name="INVOICE_ADDRESS_ID")
	private Address invoiceAddress;
	
	public void setDeliveryAddress(Address daddress) {
		this.deliveryAddress = daddress;
		daddress.getDel_customers().add(this);
	}
	
	public void setInvoiceAddress(Address iaddress) {
		this.invoiceAddress = iaddress;
		iaddress.getInv_customers().add(this);
	}
	
	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int cUSTOMER_ID) {
		customer_Id = cUSTOMER_ID;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String sALUTATION) {
		salutation = sALUTATION;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lASTNAME) {
		lastname = lASTNAME;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String fIRSTNAME) {
		firstname = fIRSTNAME;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String cUSTOMER_TYPE) {
		customerType = cUSTOMER_TYPE;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int dELETED) {
		deleted = dELETED;
	}
	
	
}
