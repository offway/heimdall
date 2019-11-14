package cn.offway.heimdall.service.impl;

import java.util.List;

import cn.offway.heimdall.service.PhLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.offway.heimdall.service.PhLockService;

import cn.offway.heimdall.domain.PhLock;
import cn.offway.heimdall.repository.PhLockRepository;


/**
 * 解锁条件表Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-21 11:31:24 Exp $
 */
@Service
public class PhLockServiceImpl implements PhLockService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhLockRepository phLockRepository;
	
	@Override
	public PhLock save(PhLock phLock){
		return phLockRepository.save(phLock);
	}
	
	@Override
	public PhLock findOne(Long id){
		return phLockRepository.findOne(id);
	}

	@Override
	public void delete(Long id){
		phLockRepository.delete(id);
	}

	@Override
	public List<PhLock> save(List<PhLock> entities){
		return phLockRepository.save(entities);
	}

	@Override
	public PhLock findByGoodsidAndTemplateTypeAndTemplateId(Long goodsid,String templateType,Long templateId){
		return phLockRepository.findByGoodsIdAndTemplateTypeAndTemplateId(goodsid,templateType,templateId);
	}

	@Override
	public PhLock findByPid(Long pid){
		return phLockRepository.findByPid(pid);
	}
}
