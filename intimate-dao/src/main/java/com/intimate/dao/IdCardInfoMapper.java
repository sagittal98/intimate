package com.intimate.dao;

import com.intimate.pojo.IdCardInfo;
import com.intimate.pojo.IdCardInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdCardInfoMapper {
    int countByExample(IdCardInfoExample example);

    int deleteByExample(IdCardInfoExample example);

    int deleteByPrimaryKey(Long idCardInfoId);

    int insert(IdCardInfo record);

    int insertSelective(IdCardInfo record);

    List<IdCardInfo> selectByExample(IdCardInfoExample example);

    IdCardInfo selectByPrimaryKey(Long idCardInfoId);

    int updateByExampleSelective(@Param("record") IdCardInfo record, @Param("example") IdCardInfoExample example);

    int updateByExample(@Param("record") IdCardInfo record, @Param("example") IdCardInfoExample example);

    int updateByPrimaryKeySelective(IdCardInfo record);

    int updateByPrimaryKey(IdCardInfo record);
}