package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleGroupBO implements ArticleGroupDAO {
    Connection connection;
    Statement stm;
    PreparedStatement pstm;

    public ArticleGroupBO() {
    	
    }
	
	public List getAllArticleGroups() throws SQLException {
	
		List<ArticleGroup> articlegroupList = new ArrayList<ArticleGroup>();
		String query = "SELECT * FROM ARTICLEGROUP";
        ResultSet rs = null;
        ArticleGroup articlegroup= null;
        try {
            connection = ConnectionFactory.getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            
            boolean recordFound = rs.next();
            while(recordFound){
            	articlegroup = new ArticleGroup();
            	articlegroup.setArticleGroup_Id(rs.getInt("ARTICLEGROUP_ID"));
            	articlegroup.setDeleted(rs.getBoolean("DELETED"));
            	articlegroup.setArticleGroup(rs.getString("ARTICLEGROUP"));
            	articlegroupList.add(articlegroup);
            	recordFound = rs.next();
            }
        } finally {
            rs.close();
            stm.close();
            connection.close();
        }
        return articlegroupList;
	}

	
	public ArticleGroup getArticleGroup(int articlegroup_id) throws SQLException {
	
		String query = "SELECT * FROM ARTICLEGROUP WHERE ARTICLEGROUP_ID = ?";
        ResultSet rs = null;
        ArticleGroup articlegroup= null;
        
        try {
            connection = ConnectionFactory.getConnection();
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, articlegroup_id);
            rs = pstm.executeQuery();
            
           articlegroup= new ArticleGroup();
            boolean recordFound = rs.next();
            if(recordFound){
            	articlegroup.setArticleGroup_Id(rs.getInt("ARTICLEGROUP_ID"));
            	articlegroup.setDeleted(rs.getBoolean("DELETED"));
            	articlegroup.setArticleGroup(rs.getString("ARTICLEGROUP"));
            }
        } finally {
        	 rs.close();
             pstm.close();
             connection.close();
        }
        return articlegroup;
	}

	
	public void updateArticleGroup(ArticleGroup articlegroup) throws SQLException {
	
		String query = 	"UPDATE ARTICLEGROUP" + 
		" SET ARTICLEGROUP = ?," +
		" DELETED = ?" +
		" WHERE ARTICLEGROUP_ID = ?;";
		
		connection = ConnectionFactory.getConnection();
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1,articlegroup.getArticleGroup());
			pstm.setBoolean(2,articlegroup.getDeleted());
			pstm.setInt(3,articlegroup.getArticleGroup_Id());
			pstm.executeUpdate();
	 		connection.commit();
			
			}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
		
		}finally{
	        pstm.close();
	        connection.close();
		}

	}

	public void createArticleGroup(ArticleGroup articlegroup) throws SQLException {

		String insert = "INSERT INTO ARTICLEGROUP (ARTICLEGROUP,DELETED) " + 
						"VALUES (?, ?)";

		connection = ConnectionFactory.getConnection();		
		try {
			pstm = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1,articlegroup.getArticleGroup());
			pstm.setBoolean(2,articlegroup.getDeleted());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
		    rs.next();
		    articlegroup.setArticleGroup_Id(rs.getInt(1));
	 		connection.commit();
			
		}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
		
		}finally{
	        pstm.close();
	        connection.close();
		}

	}

	
	public void deleteArticleGroup(ArticleGroup articlegroup) throws SQLException {
	
		String query = 	"DELETE FROM ARTICLEGROUP" + 
		" WHERE ARTICLEGROUP_ID = ?;";

		connection = ConnectionFactory.getConnection();
		try {
			pstm = connection.prepareStatement(query);
			pstm.setInt(1,articlegroup.getArticleGroup_Id());

			pstm.executeUpdate();
	 		connection.commit();
			
			}catch(Exception e) {
				connection.rollback();
				e.printStackTrace();
		
		} finally {

			  pstm.close();
	          connection.close();
		}

	}

}
