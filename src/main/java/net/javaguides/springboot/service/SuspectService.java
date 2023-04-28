package net.javaguides.springboot.service;


import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.entities.Suspect;


public interface SuspectService {
	List<Suspect> getAllSuspects();
	void saveSuspect(Suspect suspect);
	Suspect getSuspectByIdd(long id);
	void deleteSuspectById(long id);
	Page<Suspect> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}


