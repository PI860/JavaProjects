package DAPRO.ThisAndThat;

//import jakarta.persistence.Entity;
//import DAPRO.ThisAndThatJPA.Customer_Old;
import DAPRO.ThisAndThatJPA.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Paulina Pyczot
 * @date 14.11.2023
 **/

public class JPATestCustomer {
    private static final String PERSISTENCE_UNIT_NAME = "thisandthat";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Customer c2 = new Customer();
        c2.setCustomer_id(2);
//        em.persist(c2);
//        em.getTransaction().begin();
//        em.getTransaction().commit();

        // Customer_Old Config:
//        Customer_Old c1 = new Customer_Old();
//        c1.setCustomer_id(1);
//        c1.setFirstname("Paulina");
//        c1.setLastname("Pyczot");
//        em.persist(c1);
//        em.getTransaction().begin();
//        em.getTransaction().commit();
    }
}
