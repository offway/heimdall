package cn.offway.heimdall.service;

import cn.offway.heimdall.domain.PhGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.offway.heimdall.domain.PhGoods;
import cn.offway.heimdall.dto.GoodsDto;

/**
 * 商品表Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhGoodsService{

	PhGoods save(PhGoods phGoods);
	
	PhGoods findOne(Long id);

	Page<PhGoods> findByPage(GoodsDto goodsDto, Pageable page);

	String goodsConfig();
}
