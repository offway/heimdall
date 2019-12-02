package cn.offway.heimdall.repository;

import java.util.List;

import cn.offway.heimdall.domain.PhOrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhOrderGoods;
import org.springframework.data.jpa.repository.Query;

/**
 * 订单商品Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhOrderGoodsRepository extends JpaRepository<PhOrderGoods,Long>,JpaSpecificationExecutor<PhOrderGoods> {

	@Query(nativeQuery=true,value="select DISTINCT(batch) from ph_order_goods where order_no = ?1 ")
	List<String> orderSum(String orderNo);

	List<PhOrderGoods> findByOrderNo(String orderNo);

	List<PhOrderGoods> findByOrderNoAndBatch(String orderNo,String batch);

	List<PhOrderGoods> findByOrderNoAndState(String orderNo,String state);
}
