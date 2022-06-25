package com.example.seckill.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.seckill.entity.User;
import com.example.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ：qhh
 * @date ：Created in 2022/6/3 23:24
 */
@Component
public class TokenUtil {

    public static IUserService staticUserService;

    @Autowired
    public IUserService userService;

    @PostConstruct
    public void setUserService(){
        staticUserService = userService;
    }

    public static  String genToken(Integer userId, String identity){
        return JWT.create().withAudience(userId.toString())
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(identity));
    }

    public static User getCurrentUser(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (!StrUtil.isBlank(token)) {
                Integer userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
                User user = staticUserService.getById(userId);
                return user;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }
}
