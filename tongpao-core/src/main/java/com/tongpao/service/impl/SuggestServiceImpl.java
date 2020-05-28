package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.SuggestMapper;
import com.tongpao.entity.Suggest;
import com.tongpao.service.ISuggestService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 事件记录表 服务实现类
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class SuggestServiceImpl extends ServiceImpl<SuggestMapper, Suggest> implements ISuggestService {

}
