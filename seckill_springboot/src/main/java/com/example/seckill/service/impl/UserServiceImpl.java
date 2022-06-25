package com.example.seckill.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.entity.Customer;
import com.example.seckill.entity.User;
import com.example.seckill.entity.vo.UserVo;
import com.example.seckill.mapper.UserMapper;
import com.example.seckill.service.ICustomerService;
import com.example.seckill.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhh
 * @since 2022-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ICustomerService customerService;

    @Override
    public UserVo login(UserVo userVo) {
        if(StringUtils.isEmpty(userVo.getIdentity()) || StringUtils.isEmpty(userVo.getPassword())){
            return null;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("identity", userVo.getIdentity()).eq("password", userVo.getPassword());
        User one = userMapper.selectOne(queryWrapper);
        if (one != null){
            one.setPassword(null);
            BeanUtil.copyProperties(one, userVo, true);
            //        设置token
            String token = TokenUtil.genToken(one.getId(), one.getIdentity());
            userVo.setToken(token);
//            redisTemplate.opsForValue().set("user:" + token, userVo);
        }
        return userVo;
    }

    @Override
    public Boolean register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("identity", user.getIdentity());
        User one = userMapper.selectOne(queryWrapper);
        if (one != null){
            return false;
        }
        int insert = userMapper.insert(user);
        return insert > 0;
    }

    @Override
    public Boolean update(User user) {
        int i = userMapper.updateById(user);
        return i > 0;
    }

    @Override
    public Boolean isQualified(String identity) {
        Customer customer = customerService.getByIdentity(identity);
        Boolean trustworthy = customer.getTrustworthy();
        return trustworthy;
    }
}
