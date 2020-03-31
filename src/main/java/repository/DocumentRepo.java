package repository;

import entity.Document;
import entity.Request;
import entity.User;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewDocument(Document document) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer

            // Save the customer object
            em.persist(document);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public List<Document> getDocuments()  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        //User result = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Document> cr = cb.createQuery(Document.class);
            Root<Document> root = cr.from(Document.class);
            cr.select(root);  //here you pass a class field, not a table column (in this example they are called the same)

            Query<Document> query = (Query<Document>) em.createQuery(cr);
            ArrayList<Document> rs = (ArrayList<Document>) query.getResultList();
            if (!rs.isEmpty()) return rs;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            em.close();
        }
        return null;
    }

    @Transactional
    public void deleteDocument(String title)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            et = em.getTransaction();
            et.begin();

            // create delete
            CriteriaDelete<Document> delete = cb.
                    createCriteriaDelete(Document.class);

            // set the root class
            Root e = delete.from(Document.class);

            // set where clause
            delete.where(cb.equal(e.get("title"), title));

            // perform update
            em.joinTransaction();
            em.createQuery(delete).executeUpdate();
            et.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Transactional
    public void deleteUserRequests(String  username)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        User user = new UserRepo().getUserByUsername(username);
        List<Request> requests = user.getRequests();
        EntityTransaction et = null;

        for(Request request : requests) {
            try {
                CriteriaBuilder cb = em.getCriteriaBuilder();
                et = em.getTransaction();
                et.begin();

                // create delete
                CriteriaDelete<Request> delete = cb.
                        createCriteriaDelete(Request.class);

                // set the root class
                Root e = delete.from(Request.class);

                // set where clause
                delete.where(cb.equal(e.get("time"), request.getTime()));

                // perform update
                em.joinTransaction();
                em.createQuery(delete).executeUpdate();
                et.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

}
