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
@TableName("t_suggest")
public class Suggest implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;

    /**
     * 建议类型（1.功能完善改进 2.数据展现优化 3.惩处规则提议）
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 支持人数
     */
    private Integer supportCount;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;


}
