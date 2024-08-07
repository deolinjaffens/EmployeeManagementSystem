package com.ideas2it.skill.dao;

import java.util.List;
import java.util.Set;

import com.ideas2it.model.Department;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.ideas2it.util.exception.DatabaseException;
import com.ideas2it.config.hibernate.HibernateConfig;
import com.ideas2it.model.Skill;
import com.ideas2it.model.Employee;

/**
 *<p>
 *Inserts and retrieves details related to skills from the database
 *Implements the SkillDao interface
 *</p>
 *@author Deolin Jaffens
 */

public class SkillDaoImpl implements SkillDao {
	
	private static Logger logger = LogManager.getLogger(SkillDaoImpl.class);

    public int insertSkill(Skill skill) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int id = (Integer) session.save(skill);
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

    public List<Skill> getAllSkills() {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Skill> skills = session.createQuery("from Skill",Skill.class).list();
            transaction.commit();
            return skills;
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

    public Skill getSkill(int id) {
        Session session = HibernateConfig.getFactory().openSession();
        try {
            return session.get(Skill.class, id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Error with database" + e);
        } finally {
            session.close();
        }
    }

    public void updateSkill(int id, String name) throws DatabaseException {
        Session session = HibernateConfig.getFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = session.get(Skill.class, id);
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

    public void removeSkillFromEmployee(int id, int employeeId) throws DatabaseException {
         Session session = HibernateConfig.getFactory().openSession();
         Transaction transaction = null;
         try {
             transaction = session.beginTransaction();
             Skill skill = session.get (Skill.class, id);
             Employee employee = session.get(Employee.class, employeeId);
             employee.getSkills().remove(skill);
             session.update(employee);
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