package com.jumpstd.mukpick.member.mapper;

import com.jumpstd.mukpick.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository //해당 인터페이스가 저장소라는 것을 의미
public interface MemberMapper {
    public String getDate();

    public int checkUserId(String user_id);
    public int register(MemberDto memberDto);
    public int update(MemberDto memberDto);
}
