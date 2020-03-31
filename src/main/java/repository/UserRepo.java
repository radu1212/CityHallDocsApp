package repository;

import entity.Request;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.*;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserRepo {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public void insertNewUser(String username, String email, String password) {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction et = null;

		try {
			// Get transaction and start
			et = em.getTransaction();
			et.begin();

			// Create and set values for new customer
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(Boolean.FALSE);

			// Save the customer object
			em.persist(user);
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

	public User getUserByUsername(String username)  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		User result = null;
		
		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cr = cb.createQuery(User.class);
			Root<User> root = cr.from(User.class);
			cr.select(root).where(cb.equal(root.get("username"), username));  //here you pass a class field, not a table column (in this example they are called the same)

			Query<User> query = (Query<User>) em.createQuery(cr);
			ArrayList<User> rs = (ArrayList<User>) query.getResultList();
			if (!rs.isEmpty()) result = query.getSingleResult();

		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

	public List<User> getUserByUsername1(String username)  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		List<User> result = new ArrayList<>();

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cr = cb.createQuery(User.class);
			Root<User> root = cr.from(User.class);
			cr.select(root).where(cb.equal(root.get("username"), username));  //here you pass a class field, not a table column (in this example they are called the same)

			Query<User> query = (Query<User>) em.createQuery(cr);
			ArrayList<User> rs = (ArrayList<User>) query.getResultList();
			if (!rs.isEmpty()) result = query.getResultList();

		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

	public List<User> getUsers()  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		List<User> result = null;

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cr = cb.createQuery(User.class);
			Root<User> root = cr.from(User.class);
			cr.select(root);  //here you pass a class field, not a table column (in this example they are called the same)

			Query<User> query = (Query<User>) em.createQuery(cr);
			ArrayList<User> rs = (ArrayList<User>) query.getResultList();
			if (!rs.isEmpty()) result = query.getResultList();

		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

	public User getUserByUUID(String user_id)  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		User result = null;

		try {


			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cr = cb.createQuery(User.class);
			Root<User> root = cr.from(User.class);
			cr.select(root).where(cb.equal(root.get("UUID"), user_id));  //here you pass a class field, not a table column (in this example they are called the same)

			Query<User> query = (Query<User>) em.createQuery(cr);
			ArrayList<User> rs = (ArrayList<User>) query.getResultList();
			if (!rs.isEmpty()) result = query.getSingleResult();

		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

	public User getUserByEmail(String email)  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction et = null;

		User result = null;

		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<User> cr = cb.createQuery(User.class);
			Root<User> root = cr.from(User.class);
			cr.select(root).where(cb.equal(root.get("email"), email));  //here you pass a class field, not a table column (in this example they are called the same)

			Query<User> query = (Query<User>) em.createQuery(cr);
			query.setMaxResults(1);
			ArrayList<User> rs = (ArrayList<User>) query.getResultList();
			if (!rs.isEmpty()) result = query.getSingleResult();
		}catch (Exception ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}


	public void changePassword(String id, String password) {

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = null;

		User user = null;

		try {
			// Get transaction and start
			et = em.getTransaction();
			et.begin();

			// Find customer and make changes
			user = em.find(User.class, id);
			user.setPassword(password);

			// Save the customer object
			em.persist(user);
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


	public void changeEmail(String id, String email) {

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = null;

		User user = null;

		try {
			// Get transaction and start
			et = em.getTransaction();
			et.begin();

			// Find customer and make changes
			user = em.find(User.class, id);
			user.setEmail(email);

			// Save the customer object
			em.persist(user);
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
	public void deleteUser(String username)  {

		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager em = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction et = null;

		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			et = em.getTransaction();
			et.begin();

			// create delete
			CriteriaDelete<User> delete = cb.
					createCriteriaDelete(User.class);

			// set the root class
			Root e = delete.from(User.class);

			// set where clause
			delete.where(cb.equal(e.get("username"), username));

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


}
