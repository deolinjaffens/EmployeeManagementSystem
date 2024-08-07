package com.ideas2it.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.ideas2it.model.Employee;

/**
 *<p>
 *All the details of a particular skill is initialised
 *</p>
 *@author Deolin Jaffens
 */

@Entity
@Table(name = "skill")
public class Skill implements Serializable {
    
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
    private String name;
    
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private Set<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Skill(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }
	
	public Skill() {
		
	}
}