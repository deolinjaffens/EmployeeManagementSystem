package com.ideas2it.department.dao;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.model.Department;
import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.config.hibernate.HibernateConfig;

/**
 * <p>
 * Stores and retrieves required details from the database
 * Implements the DepartmentDao interface
 * </p>
 *
 * @author Deolin Jaffens
 */

public class DepartmentDaoImpl implements DepartmentDao {

    private static Logger logger = LogManager.getLogger(DepartmentDaoImpl.class);

    public int addDepartment(Department department) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(department);
            transaction.commit();
            return id;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while adding department of name {}", department.getName());
            throw new EmployeeException("Unable to add department", e);
        }
    }

    public List<Department> getAllDepartments() throws EmployeeException {
        try (Session session = HibernateConfig.getFactory().openSession()) {
            return session.createQuery("from Department", Department.class).list();
        } catch (HibernateException e) {
            logger.error("Error while extracting all the departments");
            throw new EmployeeException("Unable to extract departments", e);
        }
    }

    public Department getDepartmentById(int id) throws EmployeeException {
        try (Session session = HibernateConfig.getFactory().openSession()) {
            return session.get(Department.class, id);
        } catch (HibernateException e) {
            logger.error("Error while extracting department of id {}", id);
            throw new EmployeeException("Unable to Extract Department", e);
        }
    }

    public void updateDepartment(int id, String name) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            department.setName(name);
            session.update(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while updating department of id {}", id);
            throw new EmployeeException("Error while updating department", e);
        }
    }

    public void removeDepartment(int id) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            session.delete(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while removing department of id {}", id);
            throw new EmployeeException("Error while removing department", e);

        }
    }

}