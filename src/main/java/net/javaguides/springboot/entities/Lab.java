package net.javaguides.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="lab")
public class Lab {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_id")
    private int id;
	
    @Column(name = "address", nullable = false)
    private String address;
    

    @Column(name = "department")
    private String department;

    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="lab")
    private List<Evidence> evidence=new ArrayList<>();
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="lab")
    private List<Labtech> labtech=new ArrayList<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}





	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public List<Labtech> getLabtech() {
		return labtech;
	}


	public void setLabtech(List<Labtech> labtech) {
		this.labtech = labtech;
	}


	public List<Evidence> getEvidence() {
		return evidence;
	}


	public void setEvidence(List<Evidence> evidence) {
		this.evidence = evidence;
	}
    
    
    
    
    
}
