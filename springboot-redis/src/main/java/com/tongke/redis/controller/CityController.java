package com.tongke.redis.controller;

import com.tongke.redis.entity.City;
import com.tongke.redis.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {

    @Autowired
    private RedisService redisService;


    //http://localhost:5031/saveCity?cityName=北京&cityIntroduce=中国首都&cityId=1
    @GetMapping(value = "saveCity")
    public String saveCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        redisService.set(cityId+"",city);
        return "success";
    }



    //http://localhost:5031/getCityById?cityId=1
    @GetMapping(value = "getCityById")
    public City getCity(int cityId){
        City city = (City) redisService.get(cityId+"");
        return city;
    }
}
