package Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Output {
	private static Connection con = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			String localUrl = "jdbc:mysql://localhost:3306/";
			String db = "user01_thisandthat";
			String user = "user01";
			String pw = "user01";
			
			con = DriverManager.getConnection(localUrl + db +"?useSSL=false", user,pw);
			
			Statement sta = con.createStatement();
			
			ResultSet res = sta.executeQuery("SELECT * FROM ARTICLE");
			
			int article_id; 
			String article;
			Double price;
			String currency;
			System.out.println("ARTICLE_ID|ARTICLE|PRICE|CURRENCY\n");
			System.out.println("------------------------------------------------------------");
			while(res.next()){
				article_id = res.getInt("ARTICLE_ID");
				article = res.getString("ARTICLE");
				price = res.getDouble("PRICE");
				currency = res.getString("CURRENCY");
				System.out.printf("%4d|%18s|%5f|%3s \n", article_id,article, price,currency);
			}
			sta.close();
			res.close();
			
			
		}catch(Exception e){
		
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
