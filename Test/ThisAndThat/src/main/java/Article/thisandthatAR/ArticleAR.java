package thisandthatAR;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class ArticleAR {
	
	private Statement st;
	private Connection connection;
	
	private int article_Id;
	private String articleName;
	private float price;
	private String currency;
	private boolean deleted;
	private List articleGroups;
	/**
	 * @param artikel_Id the artikel_Id to set
	 */
	public void setArtikel_Id(int id) {
		this.article_Id = id;
	}
	/**
	 * @return the artikel_Id
	 */
	public int getArticle_Id() {
		return article_Id;
	}
	/**
	 * @param einzelpreis the einzelpreis to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the einzelpreis
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param waehrung the waehrung to set
	 */
	public void setCurrency(String cur) {
		this.currency = cur;
	}
	/**
	 * @return the waehrung
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setArticleName(String name) {
		this.articleName = name;
	}
	/**
	 * @return the bezeichnung
	 */
	public String getArticleName() {
		return articleName;
	}
	/**
	 * @param warengruppen the warengruppen to set
	 */
	public void setArticleGroups(List groups) {
		this.articleGroups = groups;
	}
	/**
	 * @return the warengruppen
	 */
	public List getArticleGroups() {
		return articleGroups;
	}

	/**
	 * used for loading from database
	 */
	public void find(int article_Id) {}
	
	/**
	 * used for creation or update in database
	 */
	public void save() {}

	/**
	 * used for deletion in database
	 */
	public void delete() {}
}
