package com.intimate.dao;

import com.intimate.pojo.Member;
import com.intimate.pojo.MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(Member record);

    int insertSelective(Member record);
    // 批量插入数据
    int insertMemberInfos(List<Member> memberList);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}