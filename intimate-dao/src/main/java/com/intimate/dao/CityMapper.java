package com.intimate.dao;

import com.intimate.pojo.City;
import com.intimate.pojo.CityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Short cityId);

    int insert(City record);

    int insertSelective(City record);
    // 批量插入
    int insertList(List<City> cityList);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Short cityId);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}