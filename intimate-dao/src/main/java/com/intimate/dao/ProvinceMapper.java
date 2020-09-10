package com.intimate.dao;

import com.intimate.pojo.Province;
import com.intimate.pojo.ProvinceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvinceMapper {
    int countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(Byte provinceId);

    int insert(Province record);

    int insertSelective(Province record);

    int insertList(List<Province> provinceList);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Byte provinceId);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}