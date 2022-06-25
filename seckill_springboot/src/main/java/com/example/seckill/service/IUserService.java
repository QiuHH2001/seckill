package com.example.seckill.service;

import com.example.seckill.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.entity.vo.UserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qhh
 * @since 2022-06-02
 */
public interface IUserService extends IService<User> {

    UserVo login(UserVo userVo);

    Boolean register(User user);

    Boolean update(User user);

    Boolean isQualified(String identity);
}
