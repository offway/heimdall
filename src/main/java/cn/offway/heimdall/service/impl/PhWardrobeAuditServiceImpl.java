package cn.offway.heimdall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.offway.heimdall.service.PhWardrobeAuditService;

import cn.offway.heimdall.domain.PhWardrobeAudit;
import cn.offway.heimdall.repository.PhWardrobeAuditRepository;


/**
 * 衣柜审核Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-20 14:44:49 Exp $
 */
@Service
public class PhWardrobeAuditServiceImpl implements PhWardrobeAuditService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhWardrobeAuditRepository phWardrobeAuditRepository;
	
	@Override
	public PhWardrobeAudit save(PhWardrobeAudit phWardrobeAudit){
		return phWardrobeAuditRepository.save(phWardrobeAudit);
	}
	
	@Override
	public PhWardrobeAudit findOne(Long id){
		return phWardrobeAuditRepository.findOne(id);
	}

	@Override
	public void delete(Long id){
		phWardrobeAuditRepository.delete(id);
	}

	@Override
	public List<PhWardrobeAudit> save(List<PhWardrobeAudit> entities){
		return phWardrobeAuditRepository.save(entities);
	}
}
