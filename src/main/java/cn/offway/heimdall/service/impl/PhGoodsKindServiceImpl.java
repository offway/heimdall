package cn.offway.heimdall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.offway.heimdall.service.PhGoodsKindService;

import cn.offway.heimdall.domain.PhGoodsKind;
import cn.offway.heimdall.repository.PhGoodsKindRepository;


/**
 * 商品种类Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-30 10:53:07 Exp $
 */
@Service
public class PhGoodsKindServiceImpl implements PhGoodsKindService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhGoodsKindRepository phGoodsKindRepository;
	
	@Override
	public PhGoodsKind save(PhGoodsKind phGoodsKind){
		return phGoodsKindRepository.save(phGoodsKind);
	}
	
	@Override
	public PhGoodsKind findOne(Long id){
		return phGoodsKindRepository.findOne(id);
	}

	@Override
	public void delete(Long id){
		phGoodsKindRepository.delete(id);
	}

	@Override
	public List<PhGoodsKind> save(List<PhGoodsKind> entities){
		return phGoodsKindRepository.save(entities);
	}

	@Override
	public List<PhGoodsKind> findByGoodsCategory(Long id){
		return phGoodsKindRepository.findByGoodsCategory(id);
	}
}
