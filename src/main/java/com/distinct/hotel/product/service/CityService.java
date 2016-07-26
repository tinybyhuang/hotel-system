package com.distinct.hotel.product.service;

import java.util.List;

import com.distinct.hotel.product.model.City;

public interface CityService {
	public City selectById(Integer id);
	public List<City> findAll();
    public List<City> selectedById(Integer Id);
    public List<City> selectedBycityIdList(List<Integer> cityIdList );
    public List<City> selectedWithoutCityIdList(List<Integer> cityIdList );
    public List<City> getAllCities();
    public List<City> findAllWithoutCityId(Integer cityId);
}
