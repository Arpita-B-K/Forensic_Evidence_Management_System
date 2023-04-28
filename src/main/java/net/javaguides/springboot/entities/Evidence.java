package net.javaguides.springboot.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="evidence")
public class Evidence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evidence_id")
	private int id;
	
	@Column(name = "name")
	private String name;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "location_found")
    private String location_found;

    
    @Column(name = "received_date")
    private LocalDate received_date;

    @Column(name = "receiving_method")
    private String receiving_method;


    
    
    @ManyToOne
    @JoinColumn(name="case_id",nullable=false)
    private ForensicCase forensicCase;
    
    
    @ManyToOne
    @JoinColumn(name="officer_id",nullable=false)
    private Officer officer;
    
    @ManyToOne
    @JoinColumn(name="lab_id")
    private Lab lab;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation_found() {
		return location_found;
	}

	public void setLocation_found(String location_found) {
		this.location_found = location_found;
	}

	public LocalDate getReceived_date() {
		return received_date;
	}

	public void setReceived_date(LocalDate received_date) {
		this.received_date = received_date;
	}

	public String getReceiving_method() {
		return receiving_method;
	}

	public void setReceiving_method(String receiving_method) {
		this.receiving_method = receiving_method;
	}

	

	public ForensicCase getForensicCase() {
		return forensicCase;
	}

	public void setForensicCase(ForensicCase forensicCase) {
		this.forensicCase = forensicCase;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}
    
    
    
    
    
	
    
    

}
