package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.sql.SQLException;
import java.util.List;
public interface ArticleDAO {

	 public List getAllArticle() throws SQLException;
	 public Article getArticle(int article_id) throws SQLException;
	 public void updateArticle(Article article) throws SQLException;
	 public void deleteArticle(Article article) throws SQLException;
	 public void createArticle(Article article) throws SQLException;
	 public void addArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException;
	 public void removeArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException;
	 
}



