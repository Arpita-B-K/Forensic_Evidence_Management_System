package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import net.javaguides.springboot.entities.Lab;
import net.javaguides.springboot.repository.LabRepository;

@Service
public class LabServiceImpl implements LabService {

	@Autowired
	private LabRepository labRepository;
	
	@Override
	public List<Lab> getAllLab() {
		return labRepository.findAll();
	}

	@Override
	public void saveLab(Lab lab) {
		this.labRepository.save(lab);
		
	}

	@Override
	public Lab getLabByIdd(long id) {
		Optional<Lab> optional = labRepository.findById(id);
		Lab lab = null;
		if (optional.isPresent()) {
			lab = optional.get();
		} else {
			throw new RuntimeException(" Lab not found for id :: " + id);
		}
		return lab;
	}

	@Override
	public void deleteLabById(long id) {
		this.labRepository.deleteById(id);
		
	}

	@Override
	public Page<Lab> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.labRepository.findAll(pageable);
	}

}
