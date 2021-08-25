package com.jumpstd.mukpick.mail.service;

import com.jumpstd.mukpick.mail.dto.MailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@PropertySource("classpath:mail.application.yml")
public class MailServiceImpl implements MailService{

    private JavaMailSender javaMailSender;

    @Value("${username}")
    private String FROM_ADDRESS;
    //private static final String FROM_ADDRESS = "hyebin9612@gmail.com";

    //인증코드 난수 생성
    private String getAuthCode(){
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num =0 ;
        while(buffer.length() < 6){
            num = random.nextInt(10);
            buffer.append(num);
        }
        return buffer.toString();
    }

    //메일전송
    public void mailSend(MailDto mailDto){
        String authKey = getAuthCode(); //6자리 난수 생성

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mailDto.getAddress()); //받는 사람 주소
            message.setFrom(FROM_ADDRESS); //보내는 사람 주소
            message.setSubject(mailDto.getTitle()); //제목
            //message.setText(mailDto.getContext()); //메일 내용
            //권한으로 회원가입 > 메일 확인> 회원가입 완료!
            //아이디 찾기는 이메일 입력해서 아이디만 보여주기
            //테이블을 따로 빼기!
            //Exception 따로 클래스를 빼서 정의?
            message.setText(authKey); //메일 내용

            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
