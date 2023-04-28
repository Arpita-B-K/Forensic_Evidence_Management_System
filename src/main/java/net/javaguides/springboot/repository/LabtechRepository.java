package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entities.Labtech;

public interface LabtechRepository extends JpaRepository<Labtech, Long>  {

}
