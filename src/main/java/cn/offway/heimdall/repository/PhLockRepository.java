package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhLock;

/**
 * 解锁条件表Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-21 11:31:24 Exp $
 */
public interface PhLockRepository extends JpaRepository<PhLock,Long>,JpaSpecificationExecutor<PhLock> {

	/** 此处写一些自定义的方法 **/
	PhLock findByGoodsIdAndTemplateTypeAndTemplateId(Long goodsid,String templateType,Long templateId);

	PhLock findByPid(Long pid);
}
