package com.ideas2it.department.dao;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.config.hibernate.HibernateConfig;

/**
 *<p>
 *Stores and retrieves required details from the database
 *Implements the DepartmentDao interface 
 *</p>
 *@author Deolin Jaffens
 */

public class DepartmentDaoImpl implements DepartmentDao {

	private static Logger logger = LogManager.getLogger(DepartmentDaoImpl.class);

    public int addDepartment(Department department) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(department);
            transaction.commit();
            return id;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
			logger.error(e.getMessage());
            throw new DatabaseException("Error with database" + e);
        } finally {
            session.close();
        }
     }

    public List<Department> getAllDepartments() throws DatabaseException {
		Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Department> departments = session.createQuery("from Department",Department.class).list();
            transaction.commit();
            return departments;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
			logger.error(e.getMessage());
            throw new DatabaseException("Department Error" + e);
        } finally {
            session.close();
        }
    }
	 
	public Department getDepartment(int id) throws DatabaseException{
        Session session = HibernateConfig.getFactory().openSession();
        try { 
            return session.get(Department.class, id);
        }catch (HibernateException e) {
		    logger.error(e.getMessage());
            throw new DatabaseException("Error with database");
        } finally {
            session.close();
        } 
    }		
	 
    public void updateDepartment(int id, String name) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
		Transaction transaction = null;
        try { 
		    transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
			department.setName(name);
			session.update(department);
			transaction.commit();
        }catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
			logger.error(e.getMessage());
            throw new DatabaseException("Error with database" + e);
        } finally {
            session.close();
        }
    }

    public void removeDepartment(int id)  throws DatabaseException {
         Session session = HibernateConfig.getFactory().openSession();
         Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             Department department = session.get (Department.class, id);
             session.delete(department);             
             transaction.commit();
         } catch (HibernateException e) {
             if(transaction != null) {
                transaction.rollback();
            }
			logger.error(e.getMessage());
            throw new DatabaseException("Database Error  " + e);
             
         } finally {
             session.close();
        }
    }

}