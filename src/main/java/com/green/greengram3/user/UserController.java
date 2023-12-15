package com.green.greengram3.user;


import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
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

    @PatchMapping("/firebase-token")
    public ResVo patchUserFirebaseToken(@RequestBody UserFirebaseTokenPatchDto dto){
        return service.patchUserFirebaseToken(dto);
    }

    @PatchMapping("/pic")
    public ResVo patchUserPic(@RequestBody UserPicPatchDto dto) {
        return service.patchUserPic(dto);}

    //pk값, nm ,pic ,
    @PostMapping("/signin")
    public UserSignInVo postUser(@RequestBody UserSignDto dto) {
        return service.signin(dto);
    }

    @GetMapping
    public UserInfoVo getUserInfo(UserInfoSelDto userInfoSelDto){
        return service.getInfo(userInfoSelDto);
    }
    @PutMapping("/update")
    public ResVo upUserpic(int iuser){
        return service.upUser(iuser);
    }

    //------------------------------follow
    //ResVo  - result: following:1, unfollowing:0
    @PostMapping("/follow")
    public ResVo toggleFollow(@RequestBody UserFollowDto dto){
       return service.toggleFollow(dto);

    }

}
