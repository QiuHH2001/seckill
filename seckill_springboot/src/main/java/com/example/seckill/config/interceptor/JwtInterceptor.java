package com.example.seckill.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.RespBeanEnum;
import com.example.seckill.exception.GlobalException;
import com.example.seckill.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/3 23:50
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        if (StrUtil.isBlank(token)){
            throw new GlobalException(RespBeanEnum.LOST_TOKEN);
        }
//        获取token中的userid
        Integer userId;
        try {
            userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
        }catch (JWTDecodeException j){
            throw new GlobalException(RespBeanEnum.TOKEN_ERROR);
        }
//        从数据库中查数据
        User user = userService.getById(userId);
        if (user == null){
            throw new GlobalException(RespBeanEnum.BIND_ERROR);
        }

//        用户identity加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getIdentity())).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
            throw new GlobalException(RespBeanEnum.BIND_ERROR);
        }
        return true;
    }
}
