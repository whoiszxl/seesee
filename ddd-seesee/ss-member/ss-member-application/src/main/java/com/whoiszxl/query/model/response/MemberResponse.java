package com.whoiszxl.query.model.response;

import com.whoiszxl.model.ddd.Representation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 会员返回实体
 *
 * @author whoiszxl
 * @date 2022/1/24
 */
@Data
@ApiModel("会员返回实体")
public class MemberResponse implements Representation {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long memberId;

    @ApiModelProperty("会员名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("谷歌验证码")
    private String googleKey;

    @ApiModelProperty("谷歌验证码是否开启，默认0不开启, 1开启")
    private Integer googleStatus;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("是否在线(0：离线 1：在线)")
    private Integer online;

    @ApiModelProperty("性别(0:未知 1:男；2:女)")
    private Integer gender;

    @ApiModelProperty("生日")
    private LocalDateTime birthday;

    @ApiModelProperty("国家码")
    private String countryCode;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区域")
    private String district;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("会员等级")
    private String gradeLevel;

    @ApiModelProperty("会员登录次数")
    private Long loginCount;

    @ApiModelProperty("会员登录错误次数")
    private Long loginErrorCount;

    @ApiModelProperty("最后登录")
    private LocalDateTime lastLogin;

    @ApiModelProperty("粉丝数")
    private Integer followerCount;

    @ApiModelProperty("关注数")
    private Integer attentionCount;

    @ApiModelProperty("获赞数")
    private Integer likesCount;
}
