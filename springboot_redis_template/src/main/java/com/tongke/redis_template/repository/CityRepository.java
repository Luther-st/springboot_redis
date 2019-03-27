package com.tongke.redis_template.repository;

import com.tongke.redis_template.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
