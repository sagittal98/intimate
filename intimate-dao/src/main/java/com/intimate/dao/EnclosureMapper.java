package com.intimate.dao;

import com.intimate.pojo.Enclosure;
import com.intimate.pojo.EnclosureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnclosureMapper {
    int countByExample(EnclosureExample example);

    int deleteByExample(EnclosureExample example);

    int deleteByPrimaryKey(Long enclosureId);

    int insert(Enclosure record);

    int insertSelective(Enclosure record);

    List<Enclosure> selectByExample(EnclosureExample example);

    Enclosure selectByPrimaryKey(Long enclosureId);

    int updateByExampleSelective(@Param("record") Enclosure record, @Param("example") EnclosureExample example);

    int updateByExample(@Param("record") Enclosure record, @Param("example") EnclosureExample example);

    int updateByPrimaryKeySelective(Enclosure record);

    int updateByPrimaryKey(Enclosure record);
}