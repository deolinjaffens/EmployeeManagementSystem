package com.ideas2it.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *<p>
 *All the details which could relate to a particular department is initialised
 *</p>
 *@author Deolin Jaffens
 */

@Entity
@Table(name = "department")
public class Department implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "name")
    private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, int id) {
        this.name = name;
        this.id = id;
    }
	
	
	public Department() {
		
	}

}