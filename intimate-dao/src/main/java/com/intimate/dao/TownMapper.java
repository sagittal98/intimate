package com.intimate.dao;

import com.intimate.pojo.Town;
import com.intimate.pojo.TownExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TownMapper {
    int countByExample(TownExample example);

    int deleteByExample(TownExample example);

    int deleteByPrimaryKey(Integer townId);

    int insert(Town record);

    int insertSelective(Town record);

    int insertList(List<Town> townList);

    List<Town> selectByExample(TownExample example);

    Town selectByPrimaryKey(Integer townId);

    List<Town> selectAll();

    int updateByExampleSelective(@Param("record") Town record, @Param("example") TownExample example);

    int updateByExample(@Param("record") Town record, @Param("example") TownExample example);

    int updateByPrimaryKeySelective(Town record);

    int updateByPrimaryKey(Town record);
}