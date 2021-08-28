package com.jumpstd.mukpick.member.service;

import com.jumpstd.mukpick.member.dao.MemberDao;
import com.jumpstd.mukpick.member.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberDao MemberDao;
    public int checkUserId(MemberDto memberDto){
        return MemberDao.checkUserId(memberDto);
    }
    public int register(MemberDto memberDto){
        return MemberDao.register(memberDto);
    }
    public int update(MemberDto memberDto){
        return MemberDao.update(memberDto);
    }
    public int passwordReset(MemberDto memberDto){
        return MemberDao.passwordReset(memberDto);
    }
}
