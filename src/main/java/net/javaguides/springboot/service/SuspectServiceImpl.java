package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entities.Suspect;
import net.javaguides.springboot.repository.SuspectRepository;

@Service
public class SuspectServiceImpl implements SuspectService {
	
	@Autowired
	private SuspectRepository suspectRepository;


	@Override
	public List<Suspect> getAllSuspects() {
		return suspectRepository.findAll();
		
	}

	@Override
	public void saveSuspect(Suspect suspect) {
		this.suspectRepository.save(suspect);
		
	}

	@Override
	public Suspect getSuspectByIdd(long id) {
		Optional<Suspect> optional = suspectRepository.findById(id);
		Suspect suspect = null;
		if (optional.isPresent()) {
			suspect = optional.get();
		} else {
			throw new RuntimeException(" suspect not found for id :: " + id);
		}
		return suspect;
		
	}

	@Override
	public void deleteSuspectById(long id) {
		this.suspectRepository.deleteById(id);
		
	}

	@Override
	public Page<Suspect> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.suspectRepository.findAll(pageable);
	}
	

}
