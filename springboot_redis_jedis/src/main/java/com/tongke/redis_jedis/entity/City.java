package com.tongke.redis_jedis.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@Table(name="city")
@DynamicUpdate(true)
@DynamicInsert(true)
public class City implements java.io.Serializable {

    private int cityId;
    private String cityName;
    private String cityIntroduce;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="city_id",nullable=true)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Column(name ="city_name",nullable=true)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name ="city_introduce",nullable=true)
    public String getCityIntroduce() {
        return cityIntroduce;
    }

    public void setCityIntroduce(String cityIntroduce) {
        this.cityIntroduce = cityIntroduce;
    }

    public City(String cityName, String cityIntroduce) {
        this.cityName = cityName;
        this.cityIntroduce = cityIntroduce;
    }
}
