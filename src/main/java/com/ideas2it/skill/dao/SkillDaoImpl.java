package com.ideas2it.skill.dao;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ideas2it.util.exception.EmployeeException;
import com.ideas2it.config.hibernate.HibernateConfig;
import com.ideas2it.model.Skill;
import com.ideas2it.model.Employee;

/**
 * <p>
 * Inserts and retrieves details related to skills from the database
 * Implements the SkillDao interface
 * </p>
 *
 * @author Deolin Jaffens
 */

public class SkillDaoImpl implements SkillDao {

    private static Logger logger = LogManager.getLogger(SkillDaoImpl.class);

    public int insertSkill(Skill skill) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(skill);
            transaction.commit();
            return id;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            throw new EmployeeException("Error with database" + e);
        }
    }

    public Skill getSkillById(int id) throws EmployeeException {
        try (Session session = HibernateConfig.getFactory().openSession()) {
            return session.get(Skill.class, id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new EmployeeException("Error with database");
        }
    }

    public void updateSkill(int id, String name) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Skill skill = session.get(Skill.class, id);
            skill.setName(name);
            session.update(skill);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            throw new EmployeeException("Error with database" + e);
        }
    }

    public void insertSkillToEmployee(int id, int employeeId) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            Skill skill = session.get(Skill.class, id);
            employee.getSkills().add(skill);
            skill.getEmployees().add(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            throw new EmployeeException("Database Error  " + e);

        }
    }

    public void removeSkillFromEmployee(int id, int employeeId) throws EmployeeException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFactory().openSession()) {
            transaction = session.beginTransaction();
            Skill skill = session.get(Skill.class, id);
            Employee employee = session.get(Employee.class, employeeId);
            employee.getSkills().remove(skill);
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            throw new EmployeeException("Database Error  " + e);

        }
    }
}