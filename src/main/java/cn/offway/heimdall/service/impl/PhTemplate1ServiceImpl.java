package cn.offway.heimdall.service.impl;

import cn.offway.heimdall.domain.PhTemplate1;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;
import cn.offway.heimdall.repository.PhTemplate1Repository;
import cn.offway.heimdall.service.PhTemplate1Service;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;
import cn.offway.heimdall.service.PhTemplate1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 杂志模版1Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-21 11:31:24 Exp $
 */
@Service
public class PhTemplate1ServiceImpl implements PhTemplate1Service {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhTemplate1Repository phTemplate1Repository;

    @Override
    @DS(DataSourceNames.BK)
    public PhTemplate1 save(PhTemplate1 phTemplate1) {
        return phTemplate1Repository.save(phTemplate1);
    }

    @Override
    @DS(DataSourceNames.BK)
    public PhTemplate1 findOne(Long id) {
        return phTemplate1Repository.findOne(id);
    }

    @Override
    @DS(DataSourceNames.BK)
    public void delete(Long id) {
        phTemplate1Repository.delete(id);
    }

    @Override
    @DS(DataSourceNames.BK)
    public List<PhTemplate1> save(List<PhTemplate1> entities) {
        return phTemplate1Repository.save(entities);
    }
}
