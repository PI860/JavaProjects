package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.sql.SQLException;
import java.util.List;

public interface ArticleGroupDAO {
	 public List getAllArticleGroups() throws SQLException;
	 public ArticleGroup getArticleGroup(int warengruppe_id) throws SQLException;
	 public void updateArticleGroup(ArticleGroup warengruppe) throws SQLException;
	 public void deleteArticleGroup(ArticleGroup warengruppe) throws SQLException;
	 public void createArticleGroup(ArticleGroup warengruppe) throws SQLException;
}
