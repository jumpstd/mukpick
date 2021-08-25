package com.jumpstd.mukpick.member.dao;

import com.jumpstd.mukpick.member.dto.MemberDto;
import com.jumpstd.mukpick.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginDaoTest {
    @Autowired
    MemberMapper mapper;
    @Test
    public void testest(){

        MemberDto dto = new MemberDto();
        dto.setUser_id("test1");
        dto.setAge(23);
        dto.setEmail("test1@gmail.com");
        dto.setPassword("test123");
        dto.setProfile_img("");
        dto.setPhone("010-1111-1111");
        dto.setGender('F');
        dto.setRole_type('2');
        dto.setUser_name("테스트");

       // System.out.println(mapper.register(dto));

    }
}