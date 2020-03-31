package repository;

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
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRequest(Request request) {
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
            em.persist(request);
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

    public List<Request> getRequests(User user)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        //User result = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Request> cr = cb.createQuery(Request.class);
            Root<Request> root = cr.from(Request.class);
            cr.select(root).where(cb.equal(root.get("user"), user));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<Request> query = (Query<Request>) em.createQuery(cr);
            ArrayList<Request> rs = (ArrayList<Request>) query.getResultList();
            if (!rs.isEmpty()) return rs;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            em.close();
        }
        return null;
    }

    public void updateRequest(String id, String newAddress) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = null;

        Request request = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            request = em.find(Request.class, id);
            request.setAddress(newAddress);

            // Save the customer object
            em.persist(request);
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

    public void changeStatus(String id, String newStatus) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = null;

        Request request = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            request = em.find(Request.class, id);
            request.setStatus(newStatus);

            // Save the customer object
            em.persist(request);
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

    @Transactional
    public void deleteRequest1(String time)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        User result = null;
        EntityTransaction et = null;

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
            delete.where(cb.equal(e.get("time"), time));

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
    public void deleteUserRequests(User  user)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager

        List<Request> requests = user.getRequests();
        EntityTransaction et = null;


            try {
                for(Request request : requests) {
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
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }

}
