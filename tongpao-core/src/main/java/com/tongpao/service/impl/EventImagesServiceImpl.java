package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.EventImagesMapper;
import com.tongpao.entity.EventImages;
import com.tongpao.service.IEventImagesService;
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
public class EventImagesServiceImpl extends ServiceImpl<EventImagesMapper, EventImages> implements IEventImagesService {

}
