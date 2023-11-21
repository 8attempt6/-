package com.langlang.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author 李作浪
 *
 */
@Data
public class UserRegisterRequest  implements Serializable {

    private static final long serialVersionUID = 4084176440847381067L;

    private String userAccount;

    private String userPassword;
    private String checkPassword;
}
