package com.xmd.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="用户实体类",description="作为系统中的用户实体，是系统的核心操作人员")
public class User implements Serializable{
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty(value = "年龄",allowEmptyValue = true)
    private String age;

}
