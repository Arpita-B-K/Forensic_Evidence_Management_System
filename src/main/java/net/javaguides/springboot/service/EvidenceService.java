package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.entities.Evidence;


public interface EvidenceService {
	List<Evidence> getAllEvidence();
	void saveEvidence(Evidence evidence);
	Evidence getEvidenceByIdd(long id);
	void deleteEvidenceById(long id);
	Page<Evidence> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
