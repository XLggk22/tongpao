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
@TableName("t_event_images")
public class EventImages implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId
	private Integer id;

    /**
     * 事件id
     */
    private Long eventId;

    /**
     * 原图地址
     */
    private String originalImgPath;

    /**
     * 马赛克图片地址
     */
    private String mosaicImgPath;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;


}
