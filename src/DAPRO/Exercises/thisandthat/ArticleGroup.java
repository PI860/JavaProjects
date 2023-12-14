//package DAPRO.Exercises.thisandthat;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Basic;
//import jakarta.persistence.Column;
//
//@Entity
//public class ArticleGroup {
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	private int articleGroup_Id;
//
//	@Basic(optional=false)
//	private String articleGroup;
//
//	@Basic(optional=false)
//	@Column(columnDefinition="TINYINT UNSIGNED")
//	private boolean deleted;
//
//	public void setArticlegroup_Id(int articleGroup_Id) {
//		this.articleGroup_Id = articleGroup_Id;
//	}
//
//	public int getArticlegroup_Id() {
//		return articleGroup_Id;
//	}
//	/**
//	 * @param articleGroup the articleGroup to set
//	 */
//	public void setArticlegroup(String articleGroup) {
//		this.articleGroup = articleGroup;
//	}
//	/**
//	 * @return the articleGroup
//	 */
//	public String getArticlegroup() {
//		return articleGroup;
//	}
//	/**
//	 * @param b the deleted to set
//	 */
//	public void setDeleted(boolean b) {
//		this.deleted = b;
//	}
//	/**
//	 * @return the deleted
//	 */
//	public boolean getDeleted() {
//		return deleted;
//	}
//
//}
