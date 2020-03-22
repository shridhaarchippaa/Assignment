package com.test.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.repository.ResourceRepository;
import com.test.entity.Resource;

@Service
@Transactional
public class ResourceService {

	@Autowired
	private ResourceRepository repository;
	
	public List<Resource> listAll() {
		return (List<Resource>) repository.findAll();
	}
	
	public Resource get(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Resource resource) {
		repository.save(resource);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
