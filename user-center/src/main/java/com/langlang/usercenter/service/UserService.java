package com.langlang.usercenter.service;

import com.langlang.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 * @author 李作浪
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2023-11-12 22:51:02
 */
public interface UserService extends IService<User> {


    /**
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 检查密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request 请求
     * @return  脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser 用户
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     *  用户注销
     * @param request 请求
     * @return 1
     */
    int userLogout(HttpServletRequest request);
}
