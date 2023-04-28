package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Officer;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Long> {

}
