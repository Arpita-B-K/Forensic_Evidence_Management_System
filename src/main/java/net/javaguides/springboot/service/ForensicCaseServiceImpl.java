package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.ForensicCase;
import net.javaguides.springboot.repository.CaseRepository;

@Service
public class ForensicCaseServiceImpl implements ForensicCaseService {

	@Autowired
	private CaseRepository caseRepository;

	@Override
	public List<ForensicCase> getAllCases() {
		return caseRepository.findAll();
	}

	@Override
	public void saveforensicCase(ForensicCase forensicCase) {
		this.caseRepository.save(forensicCase);
	}

	@Override
	public ForensicCase getForensicCaseByIdd(long id) {
		Optional<ForensicCase> optional = caseRepository.findById(id);
		ForensicCase forensicCase = null;
		if (optional.isPresent()) {
			forensicCase = optional.get();
		} else {
			throw new RuntimeException(" ForensicCase not found for id :: " + id);
		}
		return forensicCase;
	}

	@Override
	public void deleteForensicCaseById(long id) {
		this.caseRepository.deleteById(id);
	}

	@Override
	public Page<ForensicCase> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.caseRepository.findAll(pageable);
	}

}