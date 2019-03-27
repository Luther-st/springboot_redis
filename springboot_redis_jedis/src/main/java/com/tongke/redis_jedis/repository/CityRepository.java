package com.tongke.redis_jedis.repository;

import com.tongke.redis_jedis.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
