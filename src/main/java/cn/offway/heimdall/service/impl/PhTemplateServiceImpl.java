package cn.offway.heimdall.service.impl;

import cn.offway.heimdall.domain.PhTemplate;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;
import cn.offway.heimdall.repository.PhTemplateRepository;
import cn.offway.heimdall.service.PhTemplateService;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 杂志管理Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-21 12:01:34 Exp $
 */
@Service
public class PhTemplateServiceImpl implements PhTemplateService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhTemplateRepository phTemplateRepository;

    @Override
    @DS(DataSourceNames.BK)
    public PhTemplate save(PhTemplate phTemplate) {
        return phTemplateRepository.save(phTemplate);
    }

    @Override
    @DS(DataSourceNames.BK)
    public PhTemplate findOne(Long id) {
        return phTemplateRepository.findOne(id);
    }

    @Override
    @DS(DataSourceNames.BK)
    public void delete(Long id) {
        phTemplateRepository.delete(id);
    }

    @Override
    @DS(DataSourceNames.BK)
    public List<PhTemplate> save(List<PhTemplate> entities) {
        return phTemplateRepository.save(entities);
    }

    @Override
    @DS(DataSourceNames.BK)
    public List<PhTemplate> findAll() {
        return phTemplateRepository.findByStateOrderByCreateTime("0");
    }
}
