package com.intimate.dao;

import com.intimate.pojo.Village;
import com.intimate.pojo.VillageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VillageMapper {
    int countByExample(VillageExample example);

    int deleteByExample(VillageExample example);

    int deleteByPrimaryKey(Integer villageId);

    int insert(Village record);

    int insertSelective(Village record);

    int insertList(List<Village> villageList);


    List<Village> selectByExample(VillageExample example);

    Village selectByPrimaryKey(Integer villageId);

    int updateByExampleSelective(@Param("record") Village record, @Param("example") VillageExample example);

    int updateByExample(@Param("record") Village record, @Param("example") VillageExample example);

    int updateByPrimaryKeySelective(Village record);

    int updateByPrimaryKey(Village record);
}