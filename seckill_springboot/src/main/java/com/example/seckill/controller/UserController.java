package com.example.seckill.controller;

import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.RespBean;
import com.example.seckill.entity.vo.RespBeanEnum;
import com.example.seckill.entity.vo.UserVo;
import com.example.seckill.service.IUserService;
import com.example.seckill.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qhh
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {"用户管理"})
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public RespBean login(@RequestBody UserVo userVo){
        Boolean isQualified =  userService.isQualified(userVo.getIdentity());
        if (isQualified == false){
            return RespBean.error(RespBeanEnum.QUALIFIED_FAIL);
        }
        UserVo result = new UserVo();
        try {
            result = userService.login(userVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result == null){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        User currentUser = TokenUtil.getCurrentUser();

        return RespBean.success(result);
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public RespBean register(@RequestBody User user){
        Boolean flag = userService.register(user);
        if (flag == false){
            return RespBean.error(RespBeanEnum.REGISTER_ERROR);
        }
        return RespBean.success();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public RespBean update(@RequestBody User user){
        Boolean flag = userService.update(user);
        if (flag == false){
            return RespBean.error(RespBeanEnum.UPDATE_FAIL);
        }
        return RespBean.success();
    }

}
