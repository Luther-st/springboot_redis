package com.tongke.redis_template.service;


import com.tongke.redis_template.entity.City;

import java.util.List;

public interface CityService {

    City save(City user);

    City findById(Integer id);

    void delete(City user);

    List<City> findAll();
}
