package cn.offway.heimdall.service.impl;

import java.util.List;

import cn.offway.heimdall.domain.PhOrderGoods;
import cn.offway.heimdall.service.PhOrderGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.offway.heimdall.service.PhOrderGoodsService;

import cn.offway.heimdall.domain.PhOrderGoods;
import cn.offway.heimdall.repository.PhOrderGoodsRepository;


/**
 * 订单商品Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
@Service
public class PhOrderGoodsServiceImpl implements PhOrderGoodsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhOrderGoodsRepository phOrderGoodsRepository;
	
	@Override
	public PhOrderGoods save(PhOrderGoods phOrderGoods){
		return phOrderGoodsRepository.save(phOrderGoods);
	}
	
	@Override
	public List<PhOrderGoods> save(List<PhOrderGoods> phOrderGoodss){
		return phOrderGoodsRepository.save(phOrderGoodss);
	}
	
	@Override
	public PhOrderGoods findOne(Long id){
		return phOrderGoodsRepository.findOne(id);
	}
	
	@Override
	public List<PhOrderGoods> findByOrderNo(String orderNo){
		return phOrderGoodsRepository.findByOrderNo(orderNo);
	}
}
