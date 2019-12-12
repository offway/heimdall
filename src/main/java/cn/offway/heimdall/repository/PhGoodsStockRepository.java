package cn.offway.heimdall.repository;

import java.util.List;

import cn.offway.heimdall.domain.PhGoodsStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.offway.heimdall.domain.PhGoodsStock;

/**
 * 商品库存Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhGoodsStockRepository extends JpaRepository<PhGoodsStock,Long>,JpaSpecificationExecutor<PhGoodsStock> {

	List<PhGoodsStock> findByGoodsId(Long goodsId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="update ph_goods_stock s set s.stock =  s.stock-1 where  s.stock>0 and s.id = ?1 ")
	int updateStock(Long wrId);
	
	PhGoodsStock findByGoodsIdAndSizeAndColor(Long goodsId,String size,String color);

	PhGoodsStock findByGoodsIdAndRemark(Long goodsId,String remaek);
}
