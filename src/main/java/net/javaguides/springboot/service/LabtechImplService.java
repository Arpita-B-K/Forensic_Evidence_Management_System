package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import net.javaguides.springboot.entities.Labtech;
import net.javaguides.springboot.repository.LabtechRepository;


@Service
public class LabtechImplService implements LabtechService {
	
	@Autowired
	private LabtechRepository labtechRepository;


	@Override
	public List<Labtech> getAllLabtech() {
		return labtechRepository.findAll();
	}

	@Override
	public void saveLabtech(Labtech labtech) {
		this.labtechRepository.save(labtech);
		
	}

	@Override
	public Labtech getLabtechByIdd(long id) {
		Optional<Labtech> optional = labtechRepository.findById(id);
		Labtech labtech = null;
		if (optional.isPresent()) {
			labtech = optional.get();
		} else {
			throw new RuntimeException(" Labtech not found for id :: " + id);
		}
		return labtech;
	}

	@Override
	public void deleteLabtechById(long id) {
		this.labtechRepository.deleteById(id);
		
	}

	@Override
	public Page<Labtech> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.labtechRepository.findAll(pageable);
	}

}
