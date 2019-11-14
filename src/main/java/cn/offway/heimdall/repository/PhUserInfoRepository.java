package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhUserInfo;

/**
 * 用户信息Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhUserInfoRepository extends JpaRepository<PhUserInfo,Long>,JpaSpecificationExecutor<PhUserInfo> {

	PhUserInfo findByUnionid(String unionid);

	PhUserInfo findByPhone(String phone);
}
