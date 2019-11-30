package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhWardrobeAudit;
import org.springframework.data.jpa.repository.Query;

/**
 * 衣柜审核Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-20 14:44:49 Exp $
 */
public interface PhWardrobeAuditRepository extends JpaRepository<PhWardrobeAudit,Long>,JpaSpecificationExecutor<PhWardrobeAudit> {

	/** 此处写一些自定义的方法 **/

	PhWardrobeAudit findByWardrobeId(Long id);

	@Query(nativeQuery=true,value="select count(*) from ph_wardrobe_audit where unionid = ?1 and  state = 0 and is_del = 0 and use_date>DATE_FORMAT(DATE_ADD(NOW(),INTERVAL 2 day),'%Y-%m-%d')")
	int auditCount(String unionid);
}
