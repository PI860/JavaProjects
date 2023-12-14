package ThisAndThatJDBCsol.src.thisandthatDAO;

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
	
	public ArticleBO() { 
		 
	}
	
		
	public Article getArticle(int article_id) throws SQLException {

		String query = "SELECT * FROM ARTICLE WHERE ARTICLE_ID = ?";
        ResultSet rs = null;
        Article article = null;
        try {
            connection = ConnectionFactory.getConnection();
            pst = connection.prepareStatement(query);
            pst.setInt(1, article_id);
            
            rs = pst.executeQuery();
            
            article = new Article();
            boolean recordFound = rs.next();
            if(recordFound){
            	article.setArticle_Id(rs.getInt("ARTICLE_ID"));
            	article.setDeleted(rs.getBoolean("DELETED"));
            	article.setPrice(rs.getFloat("PRICE"));
            	article.setCurrency(rs.getString("CURRENCY"));
            	article.setArticleName(rs.getString("ARTICLE"));
            	article.setArticleGroups(this.getArticleGroups(article.getArticle_Id()));
            }
        } finally {
        	 rs.close();
             pst.close();
             connection.close();
        }
        return article;

	}

	public List<Article> getAllArticle() throws SQLException{

		List<Article> articleList = new ArrayList<Article>();
		String query = "SELECT * FROM ARTICLE";
        ResultSet rs = null;
        Article article = null;
        try {
            connection = ConnectionFactory.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            
            boolean recordFound = rs.next();
            while(recordFound){
            	article = new Article();
            	article.setArticle_Id(rs.getInt("ARTICLE_ID"));
            	article.setDeleted(rs.getBoolean("DELETED"));
            	article.setPrice(rs.getFloat("PRICE"));
            	article.setCurrency(rs.getString("CURRENCY"));
            	article.setArticleName(rs.getString("ARTICLE"));
            	article.setArticleGroups(this.getArticleGroups(article.getArticle_Id()));
            	articleList.add(article);
            	
            	recordFound = rs.next();
            }
        } finally {
        	 rs.close();
             stm.close();
             connection.close();
        }
        return articleList;
	}

	
	public void updateArticle(Article article) throws SQLException{
		
		String query = 	"UPDATE ARTICLE " + 
						" SET ARTICLE = ?," +
						" DELETED = ?," +
						" PRICE = ?," +
						" CURRENCY = ? " +
						" WHERE ARTICLE_ID = ?";
        
        try {
            connection = ConnectionFactory.getConnection();
            pst = connection.prepareStatement(query);
            pst.setString(1,article.getArticleName());
            pst.setBoolean(2,article.isDeleted());
            pst.setFloat(3,article.getPrice());
            pst.setString(4,article.getCurrency());
            pst.setInt(5,article.getArticle_Id());
            
            pst.executeUpdate();
    		connection.commit();
			
		}catch(Exception e) {
			connection.rollback();
			e.printStackTrace();
	
		} finally {
        	 
             pst.close();
             connection.close();
        }
        
		
	}

	
	public void deleteArticle(Article article) throws SQLException{
		String query = 	"DELETE FROM ARTICLE " + 
						" WHERE ARTICLE_ID = ?";
		
		connection = ConnectionFactory.getConnection();
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(query);
			pst.setInt(1,article.getArticle_Id());

			pst.executeUpdate();
			connection.commit();
			
		}catch(Exception e) {
			connection.rollback();
			e.printStackTrace();
	
	    } finally {
			
             pst.close();
             connection.close();
		}

	}
	
	
	public void createArticle(Article article) throws SQLException{
		String insert = 	"INSERT INTO ARTICLE (ARTICLE, DELETED, PRICE, CURRENCY) " + 
				" VALUES( ?, ?, ?, ?)";
		connection = ConnectionFactory.getConnection();
			try {
				pst = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
				pst.setString(1,article.getArticleName());
				pst.setBoolean(2,article.isDeleted());
				pst.setFloat(3,article.getPrice());
				pst.setString(4,article.getCurrency());
				pst.executeUpdate();
				ResultSet rs = pst.getGeneratedKeys();
			    rs.next();
			    article.setArticle_Id(rs.getInt(1));
	
			    
			    List <ArticleGroup> ags = article.getArticleGroups();
			    
			    for(ArticleGroup ag: ags) {
			    	this.addArticleGroup(article, ag);
			    }
				connection.commit();
				
			}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
			
			
			} finally {
				pst.close();
				connection.close();
			}
			
		
		
	}

	private List<ArticleGroup> getArticleGroups(int id_article) throws SQLException{
		List<ArticleGroup> articlegroupList = new ArrayList<ArticleGroup>();
		ResultSet rs = null;
		String query = "SELECT * FROM ARTICLE_NM_ARTICLEGROUP where ARTICLE_ID = ?";
                   
        try {
            connection = ConnectionFactory.getConnection();
            pst = connection.prepareStatement(query);
            pst.setInt(1, id_article);
            rs = pst.executeQuery();
            
            boolean recordFound = rs.next();
            while(recordFound){
            	ArticleGroupDAO agBO = new ArticleGroupBO();
            	ArticleGroup articlegroup = agBO.getArticleGroup(rs.getInt("ARTICLEGROUP_ID"));
            	articlegroupList.add(articlegroup);
            	recordFound = rs.next();
            }
        } finally {
        	 rs.close();
             pst.close();
             connection.close();
        }
		
		return articlegroupList;
	}

	@Override
	public void addArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException {
		
		String insert = "INSERT INTO ARTICLE_NM_ARTICLEGROUP (ARTICLE_ID, ARTICLEGROUP_ID) " + 
				" VALUES( ?, ?)";
		
		connection = ConnectionFactory.getConnection();
		try {
				pst = connection.prepareStatement(insert);
				pst.setInt(1,article.getArticle_Id());
				pst.setInt(2,articleGroup.getArticleGroup_Id());
				pst.executeUpdate();
				connection.commit();
				
			}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
			
			
			} finally {
				pst.close();
				connection.close();
			}
		
		article.getArticleGroups().add(articleGroup);
		
	}
	
	@Override
	public void removeArticleGroup(Article article, ArticleGroup articleGroup) throws SQLException {
		
		String delete = "DELETE FROM ARTICLE_NM_ARTICLEGROUP WHERE ARTICLE_ID = ? AND ARTICLEGROUP_ID = ?);";
		connection = ConnectionFactory.getConnection();
			try {
				
				pst = connection.prepareStatement(delete);
				pst.setInt(1,article.getArticle_Id());
				pst.setInt(2,articleGroup.getArticleGroup_Id());
				pst.executeUpdate();
				connection.commit();
				
							
			}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
				
			}finally {
			
				pst.close();
				connection.close();
			}
		
		article.getArticleGroups().remove(articleGroup);
		
	}
	
}
