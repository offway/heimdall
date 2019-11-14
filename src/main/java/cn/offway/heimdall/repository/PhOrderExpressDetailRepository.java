package cn.offway.heimdall.repository;

import java.util.List;

import cn.offway.heimdall.domain.PhOrderExpressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhOrderExpressDetail;
import java.lang.String;

/**
 * 订单物流详情Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhOrderExpressDetailRepository extends JpaRepository<PhOrderExpressDetail,Long>,JpaSpecificationExecutor<PhOrderExpressDetail> {

	List<PhOrderExpressDetail> findByMailNoOrderByAcceptTimeDesc(String mailno);
}
