package com.jumpstd.mukpick.member.dao;

import com.jumpstd.mukpick.member.dto.MemberDto;
import com.jumpstd.mukpick.member.mapper.MemberMapper;
public class MemberDaoImpl implements MemberDao{

    private MemberMapper MemberMapper;

    public int checkUserId(MemberDto memberDto){
        return MemberMapper.checkUserId(memberDto);
    }

    public int register(MemberDto memberDto){
        return MemberMapper.register(memberDto);
    }
    public int update(MemberDto memberDto){
        return MemberMapper.update(memberDto);
    }
    public int passwordReset(MemberDto memberDto){
        return MemberMapper.passwordReset(memberDto);
    }
}
