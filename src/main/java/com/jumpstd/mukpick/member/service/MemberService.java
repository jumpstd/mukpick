package com.jumpstd.mukpick.member.service;

import com.jumpstd.mukpick.member.dto.MemberDto;

public interface MemberService {

    public int checkUserId(String user_id);

    public int register(MemberDto memberDto);

    public int update(MemberDto memberDto);
}
