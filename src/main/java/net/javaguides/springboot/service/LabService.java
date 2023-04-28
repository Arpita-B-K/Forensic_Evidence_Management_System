package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.entities.Lab;

public interface LabService {
	
	List<Lab> getAllLab();
	void saveLab(Lab lab);
	Lab getLabByIdd(long id);
	void deleteLabById(long id);
	Page<Lab> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
