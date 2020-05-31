package com.tongpao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 事件记录表
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码
     */
    private String salt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headIcon;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 公司名字
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String unifiedCreditCode;

    /**
     * 身份证正面地址
     */
    private String idCardFrontImagePath;

    /**
     * 身份证反面地址
     */
    private String idCardBackImagePath;

    /**
     * 合同图片地址
     */
    private LocalDateTime contractImagePath;

    /**
     * 合同开始时间
     */
    private LocalDateTime contractStartTime;

    /**
     * 合同结束时间
     */
    private String contractEndTime;

    /**
     * 状态 1-启用 2-禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;


}
