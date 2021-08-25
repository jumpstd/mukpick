package com.jumpstd.mukpick.member.dao;

import com.jumpstd.mukpick.member.dto.MemberDto;

public interface MemberDao {

    public int checkUserId(String user_id);
    public int register(MemberDto memberDto);
    public int update(MemberDto memberDto);

}
