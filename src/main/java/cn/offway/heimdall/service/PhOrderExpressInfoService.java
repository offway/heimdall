package cn.offway.heimdall.service;

import java.util.List;

import cn.offway.heimdall.domain.PhOrderExpressInfo;

/**
 * 订单物流Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhOrderExpressInfoService{

	PhOrderExpressInfo save(PhOrderExpressInfo phOrderExpressInfo);
	
	PhOrderExpressInfo findOne(Long id);

	List<PhOrderExpressInfo> save(List<PhOrderExpressInfo> phOrderExpressInfos);

	PhOrderExpressInfo findByOrderNoAndType(String orderNo, String type);
}
