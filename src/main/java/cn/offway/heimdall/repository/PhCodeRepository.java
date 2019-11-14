package cn.offway.heimdall.repository;

import cn.offway.heimdall.domain.PhCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhCode;



/**
 * 邀请码Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhCodeRepository extends JpaRepository<PhCode,Long>,JpaSpecificationExecutor<PhCode> {

	int countByCodeAndStatus(String code,String status);
	
	PhCode findByCodeAndStatusAndPhoneAndRealName(String code,String status,String phone,String realName);
	
	PhCode findByCodeAndStatusAndPhoneAndPositionAndRealName(String code,String status,String phone,String position,String realName);
}
