package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.util.ArrayList;
import java.util.List;

public class Article {
	private int article_Id;
	private String articleName;
	private float price;
	private String currency;
	private boolean deleted;
	private List articleGroups = new ArrayList();
	/**
	 * @param article_Id the article_id to set
	 */
	public void setArticle_Id(int id) {
		this.article_Id = id;
	}
	/**
	 * @return the article_id
	 */
	public int getArticle_Id() {
		return article_Id;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String cur) {
		this.currency = cur;
	}
	/**
	 * @return the currency
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
	 * @param articleName the articleName to set
	 */
	public void setArticleName(String name) {
		this.articleName = name;
	}
	/**
	 * @return the articleName
	 */
	public String getArticleName() {
		return articleName;
	}
	/**
	 * @return the articleGroups
	 */
	public List getArticleGroups() {
		return articleGroups;
	}
	
	public void setArticleGroups(List <ArticleGroup> articleGroups) {
		this.articleGroups = articleGroups;
	}
}
