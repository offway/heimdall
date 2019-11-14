package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhLock;

/**
 * 解锁条件表Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-21 11:31:24 Exp $
 */
public interface PhLockService{

    PhLock save(PhLock phLock);
	
    PhLock findOne(Long id);

    void delete(Long id);

    List<PhLock> save(List<PhLock> entities);

    PhLock findByGoodsidAndTemplateTypeAndTemplateId(Long goodsid, String templateType, Long templateId);

    PhLock findByPid(Long pid);
}
