package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entities.Suspect;

@Repository
public interface SuspectRepository extends JpaRepository<Suspect, Long> {

}
