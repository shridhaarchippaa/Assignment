package com.nhs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhs.entity.Resource;
import com.nhs.repository.ResourceRepository;

@Controller
@RequestMapping("/assignment/")
public class ResourceController {

	private final ResourceRepository resourceRepository;

	@Autowired
	public ResourceController(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Resource resource) {
		return "add-resource";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("resources", resourceRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addResource(@Valid Resource resource, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-resource";
		}

		resourceRepository.save(resource);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Resource resource = resourceRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid resource Id:" + id));
		model.addAttribute("resource", resource);
		return "update-resource";
	}

	@PostMapping("update/{id}")
	public String updateResource(@PathVariable("id") long id, @Valid Resource resource, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			resource.setId(id);
			return "update-resource";
		}

		resourceRepository.save(resource);
		model.addAttribute("resources", resourceRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteResource(@PathVariable("id") long id, Model model) {
		Resource resource = resourceRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid resource Id:" + id));
		resourceRepository.delete(resource);
		model.addAttribute("resources", resourceRepository.findAll());
		return "index";
	}
}
