package com.jumpstd.mukpick.member.service;

import com.jumpstd.mukpick.member.dto.MemberDto;

public interface MemberService {

    public int checkUserId(MemberDto memberDto);

    public int register(MemberDto memberDto);

    public int update(MemberDto memberDto);

    public int passwordReset(MemberDto memberDto);
}
