package com.distinct.hotel.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.product.dao.CityMapper;
import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.CityExample;
import com.distinct.hotel.product.service.CityService;
@Service
public class CityServiceImpl implements CityService {
	@Resource
	private CityMapper cityMapper;

	@Override
	public List<City> findAll() {
		CityExample cityExample = new CityExample();
		cityExample.createCriteria().andIdGreaterThan(0);
		return cityMapper.selectByExample(cityExample);
	}

	@Override
	public List<City> selectedById(Integer id) {
		return cityMapper.selectById(id);
		
	}

	@Override
	public List<City> selectedBycityIdList(List<Integer> cityIdList) {
		
		return cityMapper.selectedBycityIdList(cityIdList);
	}

	@Override
	public List<City> selectedWithoutCityIdList(List<Integer> cityIdList) {
		return cityMapper.selectedWithoutCityIdList(cityIdList);
	}

	@Override
	public List<City> getAllCities() {
		
		return cityMapper.getAllCities();
	}

	@Override
	public City selectById(Integer id) {
		
		return cityMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<City> findAllWithoutCityId(Integer cityId) {
	 return cityMapper.findAllWithoutCityId(cityId);
	}

}
