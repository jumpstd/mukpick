package com.jumpstd.mukpick.member.service;

import com.jumpstd.mukpick.member.dao.MemberDao;
import com.jumpstd.mukpick.member.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberDao MemberDao;
    public int checkUserId(String user_id){
        return MemberDao.checkUserId(user_id);
    }
    public int register(MemberDto memberDto){
        return MemberDao.register(memberDto);
    }
    public int update(MemberDto memberDto){
        return MemberDao.update(memberDto);
    }
}
