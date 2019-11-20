package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhWardrobeAudit;

/**
 * 衣柜审核Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-20 14:44:49 Exp $
 */
public interface PhWardrobeAuditService{

    PhWardrobeAudit save(PhWardrobeAudit phWardrobeAudit);
	
    PhWardrobeAudit findOne(Long id);

    void delete(Long id);

    List<PhWardrobeAudit> save(List<PhWardrobeAudit> entities);
}
