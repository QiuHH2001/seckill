package com.example.seckill.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.seckill.entity.Admin;
import com.example.seckill.entity.vo.AdminVo;
import com.example.seckill.mapper.AdminMapper;
import com.example.seckill.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhh
 * @since 2022-06-07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public AdminVo login(AdminVo adminVo) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", adminVo.getName())
                .eq("password", adminVo.getPassword());
        Admin result = adminMapper.selectOne(queryWrapper);
        if (result != null){
            BeanUtil.copyProperties(result, adminVo, true);
            String token = TokenUtil.genToken(result.getId(), result.getPassword());
            adminVo.setToken(token);
            adminVo.setPassword(null);
        }
        return adminVo;
    }
}
