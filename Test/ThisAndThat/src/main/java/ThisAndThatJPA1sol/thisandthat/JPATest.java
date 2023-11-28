package ThisAndThatJPA1sol.thisandthat;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPATest {
	 private static final String PERSISTENCE_UNIT_NAME = "thisandthat";
     private static EntityManagerFactory factory;

	public static void main(String[] args) {

		 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		 EntityManager em = factory.createEntityManager();
		 
		 // Create new Article Object
		 Article art1 = new Article();
		 // Set property values
		 art1.setArticle_name("Keyboard");
		 art1.setPrice(new BigDecimal(20.99));
		 art1.setCurrency("EUR");
		 art1.setDeleted(0);

		 // store new Article in DB
		 em.persist(art1);
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 System.out.println("Article " +art1.getArticle_Id() + " created and made persistent");
		 System.out.println(art1.getArticle_Id() + " " + art1.getArticle_name() + " " + art1.getPrice() + " " + art1.getCurrency());
		 // remember auto generated id
		 int id = art1.getArticle_Id();
		 // delete reference
		 art1 = null;
		 
		 //retrieve Article from DB
		 art1 = em.find(Article.class, id);
		 System.out.println(art1.getArticle_Id() + " " + art1.getArticle_name() + " " + art1.getPrice() + " " + art1.getCurrency());
		 //change Price
		 art1.setPrice(new BigDecimal(15.99));
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 
		 System.out.println("Article " +art1.getArticle_Id() + " found and changed");
		 System.out.println(art1.getArticle_Id() + " " + art1.getArticle_name() + " " + art1.getPrice() + " " + art1.getCurrency());
		 
		 //delete Article from DB
		 em.remove(art1);
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 System.out.println("Article " +art1.getArticle_Id() + " deleted");
		 
		 ArticleGroup ag = new ArticleGroup();
		 ag.setArticlegroup("Cosmetics");
		 em.persist(ag);
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 
	}

}
