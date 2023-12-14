package Article.thisandthatDAO;

import java.sql.SQLException;
import java.util.List;

import Article.thisandthatDAO.Article;
import Article.thisandthatDAO.ArticleGroup;
public interface ArticleDAO {

	 public List getAllArticle() throws SQLException;
	 public Article getArticle(int artikel_id) throws SQLException;
	 public void updateArticle(Article artikel) throws SQLException;
	 public void deleteArticle(Article artikel) throws SQLException;
	 public void createArticle(Article article) throws SQLException;
	 public void addArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException;
	 public void removeArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException;
	 
}



