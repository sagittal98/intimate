package com.intimate.dao;

import com.intimate.pojo.Village;
import com.intimate.pojo.VillageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VillageMapper {
    int countByExample(VillageExample example);

    int deleteByExample(VillageExample example);

    int deleteByPrimaryKey(Integer villageId);

    int insert(Village record);

    int insertSelective(Village record);

    List<Village> selectByExample(VillageExample example);

    Village selectByPrimaryKey(Integer villageId);

    int updateByExampleSelective(@Param("record") Village record, @Param("example") VillageExample example);

    int updateByExample(@Param("record") Village record, @Param("example") VillageExample example);

    int updateByPrimaryKeySelective(Village record);

    int updateByPrimaryKey(Village record);
}