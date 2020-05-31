package com.tongpao.util.page;

import lombok.Data;

/**
 * 分页参数
 *
 * @author raojing
 * @date 2019-5-31 15:01
 */
@Data
public class PageParam {

    /**
     * 页码
     */
    private Integer pageNumber = 1;

    /**
     * 页大小
     */
    private Integer pageSize = 10;

}
