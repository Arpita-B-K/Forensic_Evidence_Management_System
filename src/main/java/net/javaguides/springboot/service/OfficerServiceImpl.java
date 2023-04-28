package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.Officer;

import net.javaguides.springboot.repository.OfficerRepository;


@Service
public class OfficerServiceImpl implements OfficerService {
	
	@Autowired
	private OfficerRepository officerRepository;

	@Override
	public List<Officer> getAllOfficer() {
		return officerRepository.findAll();

	}

	@Override
	public void saveOfficer(Officer officer) {
		this.officerRepository.save(officer);
		
	}

	@Override
	public Officer getOfficerByIdd(long id) {
		Optional<Officer> optional = officerRepository.findById(id);
		Officer officer = null;
		if (optional.isPresent()) {
			officer = optional.get();
		} else {
			throw new RuntimeException(" officer not found for id :: " + id);
		}
		return officer;
	}

	@Override
	public void deleteOfficerById(long id) {
		this.officerRepository.deleteById(id);
		
	}

	@Override
	public Page<Officer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.officerRepository.findAll(pageable);
	}

}
