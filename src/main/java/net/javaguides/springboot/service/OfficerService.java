package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.entities.Officer;


public interface OfficerService {

	List<Officer> getAllOfficer();
	void saveOfficer(Officer officer);
	Officer getOfficerByIdd(long id);
	void deleteOfficerById(long id);
	Page<Officer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
