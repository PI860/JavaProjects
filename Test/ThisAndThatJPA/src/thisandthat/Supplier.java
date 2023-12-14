package thisandthat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int supplier_Id;
	
	@Basic(optional=false)
	private String supplier;
	
	@Basic(optional=false)
	@Column(columnDefinition="TINYINT UNSIGNED NOT NULL")
	private int deleted;

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}

	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getDeleted() {
		return deleted;
	}
}
