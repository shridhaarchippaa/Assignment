package com.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {
    }
