package com.example.seckill.service;

import com.example.seckill.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.entity.vo.AdminVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qhh
 * @since 2022-06-07
 */
public interface IAdminService extends IService<Admin> {

    AdminVo login(AdminVo adminVo);
}
