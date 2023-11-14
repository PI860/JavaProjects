package DAPRO.thisandthatdb;

import jakarta.persistence.Entity;
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
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME):
        EntityManager em = factory.createEntityManager();

        Customer c1 = new Customer();
        c1.setCustomer_id(1);
        c1.setFirstname("Paulina");
        c1.setLastname("Pyczot");
        em.persist(c1);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
