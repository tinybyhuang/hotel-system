package com.distinct.hotel.product.dao;

import com.distinct.hotel.product.model.City;
import com.distinct.hotel.product.model.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper {

	int countByExample(CityExample example);

	int deleteByExample(CityExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(City record);

	int insertSelective(City record);

	List<City> selectByExample(CityExample example);

	City selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

	int updateByExample(@Param("record") City record, @Param("example") CityExample example);

	int updateByPrimaryKeySelective(City record);

	int updateByPrimaryKey(City record);

	List<City> selectById(Integer id);

	List<City> selectedBycityIdList(@Param("cityIdList") List<Integer> cityIdList);

	List<City> selectedWithoutCityIdList(@Param("cityIdList") List<Integer> cityIdList);

	List<City> getAllCities();

	List<Integer> findAllId();

	List<City> findAllWithoutCityId(@Param("cityId") Integer cityId);
	
}