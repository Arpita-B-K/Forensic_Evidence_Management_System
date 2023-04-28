package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.Evidence;

import net.javaguides.springboot.repository.EvidenceRepository;


@Service
public class EvidenceServiceImpl implements EvidenceService {

	@Autowired
	private EvidenceRepository evidenceRepository;

	
	@Override
	public List<Evidence> getAllEvidence() {
		return evidenceRepository.findAll();
	}

	@Override
	public void saveEvidence(Evidence evidence) {
		this.evidenceRepository.save(evidence);
		
	}

	@Override
	public Evidence getEvidenceByIdd(long id) {
		Optional<Evidence> optional = evidenceRepository.findById(id);
		Evidence evidence = null;
		if (optional.isPresent()) {
			evidence = optional.get();
		} else {
			throw new RuntimeException(" Evidence not found for id :: " + id);
		}
		return evidence;
	}

	@Override
	public void deleteEvidenceById(long id) {
		this.evidenceRepository.deleteById(id);
		
	}

	@Override
	public Page<Evidence> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.evidenceRepository.findAll(pageable);
	}

}
