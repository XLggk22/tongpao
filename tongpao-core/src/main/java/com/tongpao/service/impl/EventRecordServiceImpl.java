package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.EventRecordMapper;
import com.tongpao.entity.EventRecord;
import com.tongpao.service.IEventRecordService;
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
public class EventRecordServiceImpl extends ServiceImpl<EventRecordMapper, EventRecord> implements IEventRecordService {

}
