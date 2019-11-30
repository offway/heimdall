package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhGoodsKind;

/**
 * 商品种类Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-30 10:53:07 Exp $
 */
public interface PhGoodsKindService{

    PhGoodsKind save(PhGoodsKind phGoodsKind);
	
    PhGoodsKind findOne(Long id);

    void delete(Long id);

    List<PhGoodsKind> save(List<PhGoodsKind> entities);

    List<PhGoodsKind> findByGoodsCategory(Long id);
}
