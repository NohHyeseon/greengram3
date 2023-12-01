package com.green.greengram3.user;


import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo signup(UserSignupDto dto) {
        UserSignupProcDto dto1 = new UserSignupProcDto(dto);
        String savedPw = BCrypt.hashpw(dto1.getUpw(), BCrypt.gensalt());
        dto1.setUpw(savedPw);
        mapper.insUser(dto1);
        ResVo vo = new ResVo(dto1.getIuser());

        //비밀번호 암호화
        return vo;//회원가입한 iuser pk값이 리턴

    }
    public UserSignInVo signin(UserSignDto dto){
        UserSignProcDto savedVo=mapper.selUser(dto);
        UserSignInVo vo =new UserSignInVo();
        if(savedVo.getUpw()==null) {
            vo.setResult(Const.LOGIN_FAIL_ID_NOT_EXISTS);
            return vo;
        } else if (!BCrypt.checkpw(dto.getUpw(), savedVo.getUpw())){
            vo.setResult(Const.LOGIN_FAIL_PASSWORD_IS_NOT_CORRECT);
            return vo;
        }
        vo.setResult(Const.L0GIN_SUCCEED);
        vo.setIuser(savedVo.getIuser());
        vo.setNm(savedVo.getNm());
        vo.setPic(savedVo.getPic());


        return vo;
    }
    public UserInfoVo getInfo(int targetIuser){
        return mapper.userInfo(targetIuser);
    }
    public ResVo upUser(int iuser){
        ResVo vo = new ResVo(mapper.upUserPic(iuser));
        return vo;
    }



}
