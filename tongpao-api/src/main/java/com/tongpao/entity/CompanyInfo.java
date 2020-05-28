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
@TableName("t_company_info")
public class CompanyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
	private Integer id;

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
     * 创建来自事件ID
     */
    private Long createFromEventId;

    /**
     * 限制原因(1-实锤事件 >=1，2-基本属实事件 >= 3)
     */
    private String limitReason;

    /**
     * 限制状态（NO_LIMIT-未限制；REVIEW-审核中；LIMITED-已限制）
     */
    private String limitStatus;

    /**
     * 限制开始时间
     */
    private LocalDateTime limitStarttime;

    /**
     * 限制结束时间
     */
    private LocalDateTime limitEndtime;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;


}
