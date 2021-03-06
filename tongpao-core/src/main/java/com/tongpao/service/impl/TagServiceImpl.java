package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.TagMapper;
import com.tongpao.entity.Tag;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements IService<Tag> {

}
