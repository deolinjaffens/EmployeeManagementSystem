package com.ideas2it.employee.dao;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.config.hibernate.HibernateConfig;
import com.ideas2it.model.Employee;

/**
 * <p>
 * Stores and retrieves information related to employee from the
 * database
 * Implements the EmployeeDao interface
 * </p>
 *
 * @author Deolin Jaffens
 */

public class EmployeeDaoImpl implements EmployeeDao {

    private static Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);

    public int addEmployee(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(employee);
            transaction.commit();
            return id;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while adding employee");
            throw new EmployeeException("Unable to add employee", e);
        }
    }

    public Employee getEmployeeById(int id) throws EmployeeException {
        try (Session session = HibernateConfig.getFactory().openSession()) {
            return session.createQuery("FROM Employee e where e.id = :id and e.isDeleted = false", Employee.class).setParameter("id", id).uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error while extracting employee of id {}", id);
            throw new EmployeeException("Unable to extract employee details", e);
        }
    }

    public void updateEmployee(Employee employee) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee existingEmployee = session.get(Employee.class, employee.getId());
            if (existingEmployee != null) {
                existingEmployee.setName(employee.getName());
                session.update(existingEmployee);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while updating employee details of id {}", employee.getId());
            throw new EmployeeException("Unable to update employee details", e);
        }
    }

    public void removeEmployee(int id) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setIsDeleted(true);
                session.update(employee);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while removing employee of id {}", id);
            throw new EmployeeException("Unable to remove employee", e);

        }
    }
}