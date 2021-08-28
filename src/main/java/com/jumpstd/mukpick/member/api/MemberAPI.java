package com.jumpstd.mukpick.member.api;

import com.jumpstd.mukpick.mail.dto.MailDto;
import com.jumpstd.mukpick.mail.service.MailService;
import com.jumpstd.mukpick.member.dto.MemberDto;
import com.jumpstd.mukpick.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member/**")
public class MemberAPI {
    @Autowired
    private MemberService MemberService;
    @Autowired
    private MailService mailService;

    @GetMapping("/register")
    public String joinForm(){
        return "";
    }
    @GetMapping("/update")
    public String updateForm(){
        return "";
    }

    //아이디 중복체크
    @GetMapping("/register/{userid}")
    public Map<String,Object> checkUserId(//@PathVariable("userid") String user_id
                                          MemberDto memberDto ){
        int resultFlag = MemberService.checkUserId(memberDto);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(resultFlag == 1){
            resultMap.put("RESULT_MSG", "이미 사용중이거나 탈퇴한 아이디입니다.");
        }else{
            resultMap.put("RESULT_MSG", "멋진 아이디네요!");
        }
        resultMap.put("RESULT_FLAG", resultFlag );
        return resultMap;
    }

    //회원가입
    @PostMapping("/register")
    public Map<String,Object> register(MemberDto memberDto){
        //이메일 인증 추가
        int resultFlag = MemberService.register(memberDto);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        //파일 등록
        if(resultFlag == 1){
            resultMap.put("RESULT_MSG", "회원가입이 완료되었습니다.");
        }else{
            resultMap.put("RESULT_MSG", "회원가입이 실패되었습니다.\n관리자에게 문의부탁드립니다.");
        }
        resultMap.put("RESULT_FLAG", resultFlag );
        return resultMap;
    }
    //회원가입 유효성 검증 > 이메일, 핸드폰

    //비밀번호 찾기
    @PostMapping("/password-reset")
    public Map<String,Object>  passwordReset(MemberDto memberDto){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        //1. 아이디, 이메일이 맞는지 조회
        int checkUser = MemberService.checkUserId(memberDto);
        boolean sflag = true;
        //2. 이메일에 임시비밀번호 발급 후
        if(checkUser == 1){
            MailDto mailDto = new MailDto();
            mailDto.setTitle("[먹픽] 임시비밀번호 입니다.");
            mailDto.setAddress(memberDto.getEmail());
            mailService.mailSend(mailDto);
        }else{
            sflag = false;
            resultMap.put("RESULT_MSG", memberDto.getUser_id()+ "님의 정보가 존재하지 않습니다.");
        }
        int resultFlag = 0;
        if(sflag){
            resultFlag= MemberService.update(memberDto);

            //비밀번호 찾기
            if(resultFlag == 1){
                resultMap.put("RESULT_MSG",memberDto.getUser_id()+ "님의 임시비밀번호가 발급되었습니다.");
            }else{
                resultMap.put("RESULT_MSG", "실패되었습니다.\n관리자에게 문의부탁드립니다.");
            }
        }

        resultMap.put("RESULT_FLAG", resultFlag );
        return resultMap;
    }
    //비밀번호 초기화
    //아이디 찾기
    //회원탈퇴
    //이메일 인증

    //회원정보 수정
    @PostMapping("/update")
    public Map<String,Object> update(MemberDto memberDto){
        int resultFlag = MemberService.update(memberDto);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        //파일 등록
        if(resultFlag == 1){
            resultMap.put("RESULT_MSG",memberDto.getUser_id()+ "님의 정보수정이 완료되었습니다.");
        }else{
            resultMap.put("RESULT_MSG", memberDto.getUser_id()+ "님의 정보수정이 실패되었습니다.\n관리자에게 문의부탁드립니다.");
        }
        resultMap.put("RESULT_FLAG", resultFlag );
        return resultMap;
    }
}
