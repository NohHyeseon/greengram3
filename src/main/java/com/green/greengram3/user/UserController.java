package com.green.greengram3.user;


import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserInfoVo;
import com.green.greengram3.user.model.UserSignDto;
import com.green.greengram3.user.model.UserSignInVo;
import com.green.greengram3.user.model.UserSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResVo postSignup(@RequestBody UserSignupDto dto) {
        log.info("dto:{}", dto);
        return service.signup(dto);
    }

    //pk값, nm ,pic ,
    @PostMapping("/signin")
    public UserSignInVo postUser(@RequestBody UserSignDto dto) {
        return service.signin(dto);
    }

    @GetMapping("/info")
    public UserInfoVo getUserInfo(int targetIuser){
        return service.getInfo(targetIuser);
    }
    @PutMapping("/update")
    public ResVo upUserpic(int iuser){
        return service.upUser(iuser);
    }

}
