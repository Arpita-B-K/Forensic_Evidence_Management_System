package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {
	
	

}
