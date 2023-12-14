package ThisAndThatJDBCsol.src.thisandthatAR;

import java.util.List;

import ThisAndThatJDBCsol.src.thisandthatDAO.ConnectionFactory;

import java.sql.*;


public class ArticleAR {
	
	private int article_Id;
	private String articleName;
	private float price;
	private String currency;
	private boolean deleted;
	private List articleGroups;
	
	private Connection connection;
	private PreparedStatement pst;
	/**
	 * @param article_Id the article_id to set
	 */
	public void setArticle_id(int id) {
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
	 * @param articlename the articlename to set
	 */
	public void setArticleName(String name) {
		this.articleName = name;
	}
	/**
	 * @return the articlename
	 */
	public String getArticleName() {
		return articleName;
	}
	/**
	 * @param articleGroup the articleGroup to set
	 */
	public void setArticleGroups(List groups) {
		this.articleGroups = groups;
	}
	/**
	 * @return the articleGroup
	 */
	public List getArticleGroups() {
		return articleGroups;
	}

	/**
	 * used for loading from database
	 */
	public void find(int article_id) throws SQLException{
		
		String query = "SELECT * FROM ARTICLE WHERE ARTICLE_ID = ?";
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            pst = connection.prepareStatement(query);
            pst.setInt(1, article_id);
            
            rs = pst.executeQuery();
            
            boolean recordFound = rs.next();
            if(recordFound){
            	this.setArticle_id(rs.getInt("ARTICLE_ID"));
            	this.setDeleted(rs.getBoolean("DELETED"));
            	this.setPrice(rs.getFloat("PRICE"));
            	this.setCurrency(rs.getString("CURRENCY"));
            	this.setArticleName(rs.getString("ARTICLE"));
		    }
        } finally {
        	rs.close();   
        	pst.close();
           connection.close();
        }
      
	}
	/**
	 * used for creation or update in database
	 */
	public void save() throws SQLException{
		//new article =>INSERT
		if(this.getArticle_Id() == 0) {
			String insert = 	"INSERT INTO ARTICLE (ARTICLE, DELETED, PRICE, CURRENCY) " + 
					" VALUES( ?, ?, ?, ?)";
		
				try {
					connection = ConnectionFactory.getConnection();
					pst = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
					pst.setString(1,this.getArticleName());
					pst.setBoolean(2,this.isDeleted());
					pst.setFloat(3,this.getPrice());
					pst.setString(4,this.getCurrency());
					pst.executeUpdate();
					connection.commit();
					ResultSet rs = pst.getGeneratedKeys();
				    rs.next();
				    this.setArticle_id(rs.getInt(1));
		
				} finally {
					pst.close();
					connection.close();
				}
				
			
		}
		//existing article => UPDATE
		else {
			String update = 	"UPDATE ARTICLE " + 
				" SET ARTICLE = ?," +
				" DELETED = ?," +
				" PRICE = ?," +
				" CURRENCY = ? " +
				" WHERE ARTICLE_ID = ?";
	
			try {
				connection = ConnectionFactory.getConnection();
				pst = connection.prepareStatement(update);
				pst.setString(1,this.getArticleName());
				pst.setBoolean(2,this.isDeleted());
				pst.setFloat(3,this.getPrice());
				pst.setString(4,this.getCurrency());
				pst.setInt(5,this.getArticle_Id());
	
				pst.executeUpdate();
				connection.commit();
	
			} finally {
				pst.close();
				connection.close();
			}
		 }
	}

	/**
	 * used for deletion in database
	 */
	public void delete() throws SQLException{
		String delete = "DELETE FROM ARTICLE " + 
						"WHERE ARTICLE_ID = ?" ;
	
			try {
				connection = ConnectionFactory.getConnection();
				pst = connection.prepareStatement(delete);
				pst.setInt(1,this.getArticle_Id());
	
				pst.executeUpdate();
	
			} finally {
				connection.close();
				pst.close();
			}

	}
}
