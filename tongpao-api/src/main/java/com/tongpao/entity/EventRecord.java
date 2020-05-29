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
@TableName("t_event_record")
public class EventRecord implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一信用代码
     */
    private String unifiedCreditCode;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 法人身份证
     */
    private String legalPersonIdCard;

    /**
     * 创建用户id
     */
    private String createUserId;

    /**
     * 是否匿名 Y-是,2—否
     */
    private String anonymous;

    /**
     * 浏览次数
     */
    private Integer viewCount;

    /**
     * 评论次数
     */
    private Integer commentCount;

    /**
     * 内容
     */
    private String content;

    /**
     * 可信度(L1传言 L2疑似 L3基本属实 L4实锤)
     */
    private String credibleLevel;

    /**
     * 审核状态（SUCCESS-成功，FAIL-失败，PROCESSING-审核中）
     */
    private String approvalStatus;

    /**
     * 状态（1.有效；2.无效）
     */
    private String status;

    /**
     * 创建事件
     */
    private LocalDateTime createDatetime;

    /**
     * 更新事件
     */
    private LocalDateTime updateDatetime;


}
