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
 * 事件-关联领导表
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_event_relation_leader")
public class EventRelationLeader implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;

    /**
     * 事件id
     */
    private Long eventId;

    /**
     * 名字
     */
    private String name;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 职位
     */
    private String position;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;


}
