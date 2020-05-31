package com.tongpao.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功-视图模型
 *
 * @author raojing
 * @data 2020/5/31 15:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessVO {

    /**
     * accessToken
     */
    private String accessToken;

}
