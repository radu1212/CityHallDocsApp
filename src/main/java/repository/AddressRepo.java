package repository;

import entity.Address;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddressRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAddress(String street, String number, String apartment, String city, String county, User user) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new address
            Address address = new Address( street,  number,  apartment,  city,  county,  user);

            // Save the address object
            em.persist(address);
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
    public void deleteUserAddresses(String  username)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        User user = new UserRepo().getUserByUsername(username);
        List<Address> addresses = user.getAddresses();
        EntityTransaction et = null;

            try {
                for(Address address : addresses) {

                    CriteriaBuilder cb = em.getCriteriaBuilder();
                    et = em.getTransaction();
                    et.begin();

                    // create delete
                    CriteriaDelete<Address> delete = cb.
                            createCriteriaDelete(Address.class);

                    // set the root class
                    Root e = delete.from(Address.class);

                    // set where clause
                    delete.where(cb.equal(e.get("id"), address.getId()));

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

    @Transactional
    public void deleteAddress(Address address)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
                CriteriaBuilder cb = em.getCriteriaBuilder();
                et = em.getTransaction();
                et.begin();

                // create delete
                CriteriaDelete<Address> delete = cb.
                        createCriteriaDelete(Address.class);

                // set the root class
                Root e = delete.from(Address.class);

                // set where clause
                delete.where(cb.equal(e.get("id"), address.getId()));

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

    public List<Address> getAddresses(User user)  {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = entityManagerFactory.createEntityManager();
        // Used to issue transactions on the EntityManager
        //User result = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery<Address> cr = cb.createQuery(Address.class);
            Root<Address> root = cr.from(Address.class);
            cr.select(root).where(cb.equal(root.get("user"), user));  //here you pass a class field, not a table column (in this example they are called the same)

            Query<Address> query = (Query<Address>) em.createQuery(cr);
            ArrayList<Address> rs = (ArrayList<Address>) query.getResultList();
            if (!rs.isEmpty()) return rs;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            em.close();
        }
        return new ArrayList<Address>();
    }

}
