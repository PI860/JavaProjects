package ThisAndThatJDBCsol.src;

import java.sql.SQLException;

import thisandthatAR.ArticleAR;
import ThisAndThatJDBCsol.src.thisandthatDAO.Article;
import ThisAndThatJDBCsol.src.thisandthatDAO.ArticleBO;
import ThisAndThatJDBCsol.src.thisandthatDAO.ArticleGroup;
import ThisAndThatJDBCsol.src.thisandthatDAO.ArticleGroupBO;

public class DBTest {

	public static void main(String[] args) {
	
	/*	
	System.out.println("Active Record Implementation");
	
	try {
		//find
		float oldprice;
		
		ArticleAR article1 = new ArticleAR();
		
		article1.find(3001);
		System.out.println(article1.getArticle_Id() + "," + article1.getArticleName() + ","  + article1.getPrice());
		oldprice = article1.getPrice();
		//update
		article1.setPrice((float)19.99);
		article1.save();
		article1 = new ArticleAR();
		article1.find(3001);
		System.out.println(article1.getArticle_Id()+ "," +article1.getArticleName() + ","  + article1.getPrice());
		article1.setPrice(oldprice);
		article1.save();
		//create
		ArticleAR article2 = new ArticleAR();
		article2.setArticleName("MyTest Product");
		article2.setCurrency("EUR");
		article2.setDeleted(false);
		article2.setPrice((float)0.99);
		article2.save();
		int newid;
		newid = article2.getArticle_Id();
		article2 = new ArticleAR();
		article2.find(newid);
		System.out.println(article2.getArticle_Id()+ "," +article2.getArticleName() + ","  + article2.getPrice());
		//delete
		article2.delete();
		
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	*/
	System.out.println("DAO Implementation");
	System.out.println("Article");
	try {
		//find
		float oldprice;
		
		ArticleBO articleBO = new ArticleBO();
		
		Article article1 =articleBO.getArticle(3001);
		System.out.println(article1.getArticle_Id() + "," + article1.getArticleName() + ","  + article1.getPrice());
		oldprice = article1.getPrice();
		//update
		article1.setPrice((float)19.99);
		articleBO.updateArticle(article1);
		article1 =articleBO.getArticle(3001);
		System.out.println(article1.getArticle_Id() + "," + article1.getArticleName() + ","  + article1.getPrice());
		article1.setPrice(oldprice);
		articleBO.updateArticle(article1);
		//create
		Article article2 = new Article();
		article2.setArticleName("MyTest Product");
		article2.setCurrency("EUR");
		article2.setDeleted(false);
		article2.setPrice((float)0.99);
		articleBO.createArticle(article2);
		int newid;
		newid = article2.getArticle_Id();
		article2 = new Article();
		article2 =articleBO.getArticle(newid);
		System.out.println(article2.getArticle_Id()+ "," +article2.getArticleName() + ","  + article2.getPrice());
		//delete
		articleBO.deleteArticle(article2);
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("ArticleGroup");
	try {
		//find
		String oldname;
		
		ArticleGroupBO articlegroupBO = new ArticleGroupBO();
		
		ArticleGroup articlegroup1 =articlegroupBO.getArticleGroup(1);
		System.out.println(articlegroup1.getArticleGroup_Id() + "," + articlegroup1.getArticleGroup());
		oldname = articlegroup1.getArticleGroup();
		//update
		articlegroup1.setArticleGroup("Office Stuff");
		articlegroupBO.updateArticleGroup(articlegroup1);
		articlegroup1 =articlegroupBO.getArticleGroup(1);
		System.out.println(articlegroup1.getArticleGroup_Id() + "," + articlegroup1.getArticleGroup());
		articlegroup1.setArticleGroup(oldname);
		articlegroupBO.updateArticleGroup(articlegroup1);
		//create
		ArticleGroup articlegroup2 = new ArticleGroup();
		articlegroup2.setArticleGroup("MyTest Product");
		articlegroup2.setDeleted(false);
		articlegroupBO.createArticleGroup(articlegroup2);
		int newid;
		newid = articlegroup2.getArticleGroup_Id();
		articlegroup2 = new ArticleGroup();
		articlegroup2 =articlegroupBO.getArticleGroup(newid);
		System.out.println(articlegroup2.getArticleGroup_Id()+ "," +articlegroup2.getArticleGroup());
		//delete
		articlegroupBO.deleteArticleGroup(articlegroup2);
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
