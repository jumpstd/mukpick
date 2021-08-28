package com.jumpstd.mukpick.mail.service;

import com.jumpstd.mukpick.mail.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

@Service
public class MailServiceImpl implements MailService{
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

    public void mailSend(MailDto mailDto) {
        //권한으로 회원가입 > 메일 확인> 회원가입 완료!
        //아이디 찾기는 이메일 입력해서 아이디만 보여주기
        //테이블을 따로 빼기!
        //Exception 따로 클래스를 빼서 정의?
        // message.setText(authKey); //메일 내용

        String host = "smtp.gmail.com";
        String sender = "hyebin9612@gmail.com";
        String password = "cm6833cmcm@@";

        String from = mailDto.getAddress();
        // SMTP 서버 정보를 설정
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");

        //properties에 저장되어 있는 설정값을 getDefaultInstance()메소드로 저장하여 세션 생성
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        try {
            String authKey = getAuthCode(); //6자리 난수 생성
            MimeMessage message = new MimeMessage(session);
            //받는사람 메일
            message.setFrom(new InternetAddress(from));
            //수신자
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sender));
            // 메일 제목
            message.setSubject(mailDto.getTitle());
            // 메일 내용
            message.setText("인증번호는 "+authKey+"입니다.");
            // send the message
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
