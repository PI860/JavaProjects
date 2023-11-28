package Article.thisandthatDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleBO implements ArticleDAO {
	
	private Connection connection;
	private Statement stm;
	private PreparedStatement pst;

	public ArticleBO() { }
	
	public Article getArticle(int article_Id) throws SQLException {

		String query = "SELECT * FROM ARTICLE WHERE ARTICLE_Id = ?";
        ResultSet rs = null;
        Article article = null;
        try {
            connection = ConnectionFactory.getConnection();
            pst = connection.prepareStatement(query);
           //...//
		   
        } finally {
        	rs.close();
            pst.close();
            connection.close();
        }
        return article;

	}

	public List<Article> getAllArticle() throws SQLException{
		
        return null;
	}

	
	public void updateArticle(Article article) throws SQLException{
		
		
	}

	
	public void deleteArticle(Article article) throws SQLException{
		

	}
	
	
	private List getArticleGroups(int id_article) throws SQLException{
		return null;
	}

	public void createArticle(Article article) throws SQLException {
		
		
	}

	@Override
	public void addArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException {
		
		
	}

	@Override
	public void removeArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException {
		
		
	}
}
