package cn.offway.heimdall.service.impl;

import java.util.List;

import cn.offway.heimdall.domain.PhGoodsStock;
import cn.offway.heimdall.domain.PhWardrobe;
import cn.offway.heimdall.service.PhGoodsStockService;
import cn.offway.heimdall.service.PhWardrobeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.offway.heimdall.repository.PhGoodsStockRepository;


/**
 * 商品库存Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
@Service
public class PhGoodsStockServiceImpl implements PhGoodsStockService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhGoodsStockRepository phGoodsStockRepository;

	@Autowired
	private PhWardrobeService phWardrobeService;

	@Override
	public PhGoodsStock save(PhGoodsStock phGoodsStock){
		return phGoodsStockRepository.save(phGoodsStock);
	}
	
	@Override
	public PhGoodsStock findOne(Long id){
		return phGoodsStockRepository.findOne(id);
	}
	
	@Override
	public List<PhGoodsStock> findByGoodsId(Long goodsId){
		return phGoodsStockRepository.findByGoodsId(goodsId);
	}
	
	@Override
	public int updateStock(Long wrId){
		PhWardrobe phWardrobe = phWardrobeService.findOne(wrId);
		String remaek = phWardrobe.getColor()+"_"+phWardrobe.getSize()+"_";
		PhGoodsStock phGoodsStock = findByGoodsIdAndRemark(phWardrobe.getGoodsId(),remaek);
		return phGoodsStockRepository.updateStock(phGoodsStock.getId());
	}
	
	@Override
	public PhGoodsStock findByGoodsIdAndSizeAndColor(Long goodsId,String size,String color){
		return phGoodsStockRepository.findByGoodsIdAndSizeAndColor(goodsId, size, color);
	}

	@Override
	public PhGoodsStock findByGoodsIdAndRemark(Long goodsId, String remaek){
		return phGoodsStockRepository.findByGoodsIdAndRemark(goodsId,remaek);
	}
}
