package com.jumpstd.mukpick.member.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDto {
    private String user_id;
    private String password;
    private String user_name;
    private String phone;
    private String profile_img;
    private String email;
    private char role_type;
    private char gender;
    private int age;
}
