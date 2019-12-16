package gestores.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gestores.model.Gestor;
import gestores.utl.HibernateUtil;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class GestorDao {
	
	/**
	 * Save gestor
	 * @param gestor
	 */
	public void saveGestor(Gestor gestor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(gestor);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update gestor
	 * @param gestor
	 */
	public void updateGestor(Gestor gestor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(gestor);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete gestor
	 * @param id
	 */
	public void deleteGestor(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Gestor gestor = session.get(Gestor.class, id);
			if (gestor != null) {
				session.delete(gestor);
				System.out.println("gestor is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Gestor By ID
	 * @param id
	 * @return
	 */
	public Gestor getGestor(int id) {

		Transaction transaction = null;
		Gestor gestor = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			gestor = session.get(Gestor.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return gestor;
	}
	
	/**
	 * Get all Gestores
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Gestor> getAllGestor() {

		Transaction transaction = null;
		List<Gestor> listOfGestor = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfGestor = session.createQuery("from Gestor").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfGestor;
	}
}
