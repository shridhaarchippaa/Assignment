package com.test.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Resource;
import com.test.service.ResourceService;

@RestController
public class ResourceController {

	@Autowired
	private ResourceService service;

	@GetMapping("/assignments")
	public List<Resource> list() {
		return service.listAll();
	}
	
	@GetMapping("/assignments/{id}")
	public ResponseEntity<Resource> get(@PathVariable Long id) {
		try {
			Resource resource = service.get(id);
			return new ResponseEntity<Resource>(resource, HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/assignments")
	public void add(@RequestBody Resource resource) {
		service.save(resource);
	}
	
	@PutMapping("/assignments/{id}")
	public ResponseEntity<Resource> update(@RequestBody Resource resource, @PathVariable Long id) {
		try {
			Resource existingResource = service.get(id);
			existingResource.setEmail(resource.getEmail());
			existingResource.setName(resource.getName());
			existingResource.setSkill(resource.getSkill());
			service.save(existingResource);
			return new ResponseEntity<Resource>(existingResource, HttpStatus.OK);
		} catch(NoSuchElementException  e) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/assignments/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
