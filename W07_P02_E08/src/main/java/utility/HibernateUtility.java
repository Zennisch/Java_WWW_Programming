package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtility {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public HibernateUtility() {
        entityManagerFactory = Persistence.createEntityManagerFactory("W07_P02_E08");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        HibernateUtility hibernateUtility = new HibernateUtility();
        System.out.println(hibernateUtility.getEntityManager().createQuery("SELECT 1").getSingleResult());
    }

}
