package com.intimate.dao;

import com.intimate.pojo.CourierNumber;
import com.intimate.pojo.CourierNumberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierNumberMapper {
    int countByExample(CourierNumberExample example);

    int deleteByExample(CourierNumberExample example);

    int deleteByPrimaryKey(Long cnId);

    int insert(CourierNumber record);

    int insertSelective(CourierNumber record);

    List<CourierNumber> selectByExample(CourierNumberExample example);

    CourierNumber selectByPrimaryKey(Long cnId);

    int updateByExampleSelective(@Param("record") CourierNumber record, @Param("example") CourierNumberExample example);

    int updateByExample(@Param("record") CourierNumber record, @Param("example") CourierNumberExample example);

    int updateByPrimaryKeySelective(CourierNumber record);

    int updateByPrimaryKey(CourierNumber record);
}