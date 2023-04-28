package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Evidence;


@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {

}
