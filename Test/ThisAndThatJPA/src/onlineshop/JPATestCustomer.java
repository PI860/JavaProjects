package onlineshop;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPATestCustomer {
	 private static final String PERSISTENCE_UNIT_NAME = "mysql_oshop";
     private static EntityManagerFactory factory;

	public static void main(String[] args) {

		 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		 EntityManager em = factory.createEntityManager();

		
		 		 
		 /* Create new Customer  */
		 Customer cust1 = new Customer();
		 cust1.setSalutation("Prof.");
		 cust1.setFirstname("Volker");
		 cust1.setLastname("Herbort");
		 cust1.setCustomerType("PRIVATE");
		 
		 cust1.setDeleted(0);
		 
		 
		 Customer cust2 = new Customer();
		 cust2.setSalutation("Prof.");
		 cust2.setFirstname("Horst");
		 cust2.setLastname("Zipfelhuber");
		 cust2.setCustomerType("PRIVATE");
		 
		 cust2.setDeleted(0);
		 
		 /* Create new Address*/
		 Address adr1 = new Address();
		 adr1.setStreet("Albert-Einstein-Allee 55");
		 adr1.setPostalCode("89081");
		 adr1.setCity("Ulm");
		 adr1.setCountry("DE");
 		 adr1.setDeleted(0);
 		 
 		 // Connect Objects => establish relation
  		 cust1.setDeliveryAddress(adr1);
  		 cust2.setDeliveryAddress(adr1);
 		 
 		 /* Create new Address*/
		 Address adr2 = new Address();
		 adr2.setStreet("Prittwitzstrasse 10");
		 adr2.setPostalCode("89075");
		 adr2.setCity("Ulm");
		 adr2.setCountry("DE");
 		 adr2.setDeleted(0);
		
 		 // Connect Objects => establish relation
  		 
 		 cust1.setInvoiceAddress(adr2);
 		 cust2.setInvoiceAddress(adr2);
		 
		 
		// store new Customer in DB
		 em.persist(cust1);
		 em.persist(cust2);
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 
		 em.remove(cust1);
		 em.getTransaction().begin();
		 em.getTransaction().commit();
		 		
	}

}
