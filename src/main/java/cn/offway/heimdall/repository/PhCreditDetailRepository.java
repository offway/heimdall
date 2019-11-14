package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhCreditDetail;

/**
 * 信用明细Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhCreditDetailRepository extends JpaRepository<PhCreditDetail,Long>,JpaSpecificationExecutor<PhCreditDetail> {

	/** 此处写一些自定义的方法 **/
}
