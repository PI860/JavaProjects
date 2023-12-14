package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.util.ArrayList;
import java.util.List;

public class ArticleGroup {
	private int articleGroup_Id;
	private String articleGroup;
	private boolean deleted;
	private List <Article> articles = new ArrayList<Article>();
	
	/**
	 * @param articleGroup_Id the articlegroup_id to set
	 */
	public void setArticleGroup_Id(int group_id) {
		this.articleGroup_Id = group_id;
	}
	/**
	 * @return the articlegroup_id
	 */
	public int getArticleGroup_Id() {
		return articleGroup_Id;
	}
	/**
	 * @param group the group to set
	 */
	public void setArticleGroup(String group) {
		this.articleGroup = group;
	}
	/**
	 * @return the group
	 */
	public String getArticleGroup() {
		return articleGroup;
	}
	/**
	 * @param b the deleted to set
	 */
	public void setDeleted(boolean b) {
		this.deleted = b;
	}
	/**
	 * @return the deleted
	 */
	public boolean getDeleted() {
		return deleted;
	}
	
	public List<Article> getArticles(){
		return this.articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
