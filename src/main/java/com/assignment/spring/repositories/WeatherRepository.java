package com.assignment.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.assignment.spring.entities.WeatherEntity;

public interface WeatherRepository extends CrudRepository<WeatherEntity, Integer> {
}
