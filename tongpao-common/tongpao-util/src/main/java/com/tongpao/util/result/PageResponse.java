package com.tongpao.util.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author raojing
 * @date 2019/12/3 12:37
 */
@Getter
@AllArgsConstructor
public class PageResponse<T> {

    /**
     * 总数
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> list;

    public static <T> PageResponse<T> build(Long total, List<T> data) {
        return new PageResponse<>(total, data);
    }

}
