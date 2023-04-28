package net.javaguides.springboot.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "suspect")
public class Suspect {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suspect_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="case_id",nullable=false)
   private ForensicCase forensicCase;

   
    

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ForensicCase getForensicCase() {
		return forensicCase;
	}

	public void setForensicCase(ForensicCase forensicCase) {
		this.forensicCase = forensicCase;
	}

	

	
	

	
	
	
}
