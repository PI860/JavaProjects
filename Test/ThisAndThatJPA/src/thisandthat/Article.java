package thisandthat;

import java.math.BigDecimal;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int article_Id;
	
	@Basic(optional=false)
	private String article;
	
	@Basic(optional=false)
	@Column(precision=6,scale=2)	
	private BigDecimal price;
	
	//@Basic(optional=true)
	@Column(columnDefinition="CHAR(3)")
	private String currency;
	
	@Basic(optional=false)
	@Column(columnDefinition="TINYINT UNSIGNED NOT NULL")
	private int deleted;
	//private boolean deleted;

	public void setArticle_Id(int artikel_id) {
		this.article_Id = artikel_id;
	}

	public int getArticle_Id() {
		return article_Id;
	}

	public void setArticle_name(String bezeichung) {
		this.article = bezeichung;
	}

	public String getArticle_name() {
		return article;
	}

	public void setPrice(BigDecimal einzelpreis) {
		this.price = einzelpreis;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setCurrency(String waehrung) {
		this.currency = waehrung;
	}

	public String getCurrency() {
		return currency;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getDeleted() {
		return deleted;
	}
}
