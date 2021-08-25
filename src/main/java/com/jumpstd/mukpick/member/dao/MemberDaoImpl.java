package com.jumpstd.mukpick.member.dao;

import com.jumpstd.mukpick.member.dto.MemberDto;
import com.jumpstd.mukpick.member.mapper.MemberMapper;
public class MemberDaoImpl implements MemberDao{

    private MemberMapper MemberMapper;

    public int checkUserId(String user_id){
        return MemberMapper.checkUserId(user_id);
    }

    public int register(MemberDto memberDto){
        return MemberMapper.register(memberDto);
    }
    public int update(MemberDto memberDto){
        return MemberMapper.update(memberDto);
    }
}
