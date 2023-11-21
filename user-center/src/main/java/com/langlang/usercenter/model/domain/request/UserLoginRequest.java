package com.langlang.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登陆请求体
 *
 * @author 李作浪
 *
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 4084176440847381067L;

    private String userAccount;

    private String userPassword;

}
