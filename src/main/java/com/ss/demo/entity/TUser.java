package com.ss.demo.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TUser {

    private Integer id;

    private String username;

    private String password;

    /**
     * 1正常 2禁用
     */
    private Integer status;

    /**
     * 角色
     */
    private String roles;

    /**
     * 创建时间
     */
    private Date createTime;
}