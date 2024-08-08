package com.ideas2it.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *<p>
 *All the details related to an employee is initialised
 *</p>
 *@author Deolin Jaffens
 */

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "dob")
    private LocalDate dob;
	
	@Column(name = "gender")
    private char gender;
	
	@Column(name = "phone_number")
    private long phoneNumber;
	
	@Column(name = "salary")
    private double salary;
	
	@Column(name = "is_deleted")
    private boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
    private Department department;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_skill", joinColumns = {@JoinColumn(name = "employee_id")}, inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private Set<Skill> skills;

    public String getName() {
	    return name;
    }

    public void setName(String name) {
	    this.name = name;
    }
	
    public LocalDate getDob() {
	    return dob;
    }

    public void setDob(LocalDate dob) {
	    this.dob=dob;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public char getGender() {
	return gender;
    }

    public void setGender(char gender) {
	this.gender=gender;
    }

    public long getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber){
	this.phoneNumber=phoneNumber;
    }

    public double getSalary(){
	return salary;
    }

    public void setSalary(double salary) {
	this.salary=salary;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department){
        this.department = department;
    }

    public Employee(String name, LocalDate dob, char gender, long phoneNumber, double salary,Department department) {
	    this.name = name;
	    this.dob = dob;
	    this.gender = gender;
	    this.phoneNumber = phoneNumber;
	    this.salary = salary;
        this.isDeleted = false;
        this.skills = new HashSet<>();
		this.department = department;
    }
	
	public Employee(String name, LocalDate dob, int id, char gender, long phoneNumber, double salary) { 
	    this.name = name;
	    this.dob = dob;
	    this.gender = gender;
	    this.id = id;
	    this.phoneNumber = phoneNumber;
	    this.salary = salary;
        this.isDeleted = false;
        this.skills = new HashSet<>();
    }
	
	public Employee() {
		
	}

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}