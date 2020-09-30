package com.intimate.dao;


import com.intimate.pojo.Member;
import com.intimate.pojo.MemberExample;
import com.intimate.pojo.Province;
import com.intimate.pojo.User;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//// 告诉junit spring配置文件
//@ContextConfiguration({"classpath:spring/spring-*.xml"})

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class Tests {
//
//    @Autowired
//    private RedisTemplate<String,Objects> redisTemplate;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void test1(){
        Long groupId = 12L;
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);

    }
}
