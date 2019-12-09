package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhGoodsProperty;

/**
 * 商品属性Service接口
 *
 * @author tbw
 * @version $v: 1.0.0, $time:2019-12-09 13:28:39 Exp $
 */
public interface PhGoodsPropertyService{

    PhGoodsProperty save(PhGoodsProperty phGoodsProperty);
	
    PhGoodsProperty findOne(Long id);

    void delete(Long id);

    List<PhGoodsProperty> save(List<PhGoodsProperty> entities);

    List<PhGoodsProperty> findByGoodsStockId(Long id);
}
