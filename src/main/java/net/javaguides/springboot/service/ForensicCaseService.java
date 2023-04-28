package net.javaguides.springboot.service;


import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.entities.ForensicCase;


public interface ForensicCaseService {
	List<ForensicCase> getAllCases();
		void saveforensicCase(ForensicCase forensicCase);
		ForensicCase getForensicCaseByIdd(long id);
		void deleteForensicCaseById(long id);
		Page<ForensicCase> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}