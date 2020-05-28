package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.CompanyInfoMapper;
import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
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
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfo> implements ICompanyInfoService {

}
