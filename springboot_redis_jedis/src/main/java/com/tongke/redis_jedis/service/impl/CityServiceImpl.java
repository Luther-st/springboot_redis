package com.tongke.redis_jedis.service.impl;

import com.tongke.redis_jedis.entity.City;
import com.tongke.redis_jedis.repository.CityRepository;
import com.tongke.redis_jedis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City save(City user) {
        return cityRepository.save(user);
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id).get();
    }

    public void delete(City user) {
        cityRepository.delete(user);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
