package net.javaguides.springboot.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="forensicCase")
public class ForensicCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    private int id;
    
    @Column(name = "name")
    private String name;

    
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "status")
    private String status;

    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="forensicCase")
    private List<Suspect> suspect=new ArrayList<>();
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="forensicCase")
    private List<Officer> officer=new ArrayList<>();
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="forensicCase")
    private List<Evidence> evidence=new ArrayList<>();
	
	
	
	

	public ForensicCase() {
		super();
		// TODO Auto-generated constructor stub
	}





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





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public List<Suspect> getSuspect() {
		return suspect;
	}





	public void setSuspect(List<Suspect> suspect) {
		this.suspect = suspect;
	}





	public List<Officer> getOfficer() {
		return officer;
	}





	public void setOfficer(List<Officer> officer) {
		this.officer = officer;
	}





	public List<Evidence> getEvidence() {
		return evidence;
	}





	public void setEvidence(List<Evidence> evidence) {
		this.evidence = evidence;
	}


	
	



	




	



	




	
	


	
	
	
	
	
 
}
