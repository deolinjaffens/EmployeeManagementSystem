package com.ideas2it.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.config.hibernate.HibernateConfig;
import com.ideas2it.model.Employee;

/**
 * <p>
 *Stores and retrieves information related to employee from the
 *database
 *Implements the EmployeeDao interface
 *</p>
 *@author Deolin Jaffens
 */

public class EmployeeDaoImpl implements EmployeeDao  {
	
	private static Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);

    public int addEmployee(Employee employee) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(employee);
            transaction.commit();
            return id;
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            throw new DatabaseException("Error with database" + e);
        } finally {
            session.close();
        }
    }

    public Employee getEmployee(int id) throws DatabaseException {
		Session session = HibernateConfig.getFactory().openSession();
		try {
			return session.get(Employee.class, id);
		} catch (HibernateException e) {
		    logger.error(e.getMessage());
            throw new DatabaseException("Error with database" + e);
        } finally {
            session.close();
        }
    }   

    public void updateEmployee(Employee employee) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee existingEmployee = session.get(Employee.class, employee.getId());
            if (existingEmployee != null) {
                existingEmployee.setName(employee.getName());
                session.update(existingEmployee );
                transaction.commit();
            }
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

    public void removeEmployee(int id) throws DatabaseException {
       Session session = HibernateConfig.getFactory().openSession();
         Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             Employee employee = session.get (Employee.class, id);
             if (employee != null) {
                 employee.setDelete(false);
                 session.update(employee);				 
                 transaction.commit();
             }
             else {
                 throw new DatabaseException("Database Error " + id);
             }
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

    public List<Employee> getEmployees() throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee where is_deleted = false", Employee.class).list();
            transaction.commit();
            return employees;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
			logger.error(e.getMessage());
            throw new DatabaseException("Database Error " + e);
        } finally {
            session.close();
        }
    }   
}