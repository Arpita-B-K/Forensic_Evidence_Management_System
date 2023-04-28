package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;


import net.javaguides.springboot.entities.Labtech;

public interface LabtechService {
	List<Labtech> getAllLabtech();
	void saveLabtech(Labtech labtech);
	Labtech getLabtechByIdd(long id);
	void deleteLabtechById(long id);
	Page<Labtech> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
