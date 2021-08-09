package com.assignment.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.spring.entities.EntityWeather;

@Repository
public interface WeatherRepository extends CrudRepository<EntityWeather, Integer> {
}
