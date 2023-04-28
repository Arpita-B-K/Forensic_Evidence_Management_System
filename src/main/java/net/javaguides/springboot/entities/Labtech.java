package net.javaguides.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="labtech")
public class Labtech {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labtech_id")
    private int id;
    
    @Column(name = "name")
    private String name;

    
    @Column(name = "designation")
    private String designation;

    @Column(name = "department")
    private String department;
    
    @ManyToOne
    @JoinColumn(name="lab_id", nullable = false)
    private Lab lab;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}
    
    
    
    
    
	
    

}
