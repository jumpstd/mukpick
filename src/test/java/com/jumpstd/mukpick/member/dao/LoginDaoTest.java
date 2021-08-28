package com.jumpstd.mukpick.member.dao;

import com.jumpstd.mukpick.mail.api.MailAPI;
import com.jumpstd.mukpick.mail.dto.MailDto;
import com.jumpstd.mukpick.mail.service.MailService;
import com.jumpstd.mukpick.member.dto.MemberDto;
import com.jumpstd.mukpick.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginDaoTest {
    @Autowired
    MemberMapper mapper;

    @Autowired
    MailService mailService;

    @Test
    public void testest(){

       /* MemberDto dto = new MemberDto();
        dto.setUser_id("test1");
        dto.setAge(23);
        dto.setEmail("test1@gmail.com");
        dto.setPassword("test123");
        dto.setProfile_img("");
        dto.setPhone("010-1111-1111");
        dto.setGender('F');
        dto.setRole_type('2');
        dto.setUser_name("테스트");*/
        MailDto mailDto = new MailDto();
        mailDto.setTitle("테스트 메일입니다.");
        mailDto.setAddress("hyebin9612@gmail.com");
        mailService.mailSend(mailDto);
       // System.out.println(mapper.register(dto));

    }
}