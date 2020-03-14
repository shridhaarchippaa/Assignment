package com.nhs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nhs.entity.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {
    
    List<Resource> findByName(String name);
    
}
