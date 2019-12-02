package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhAddressBrand;

/**
 * 品牌地址管理Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-12-02 14:49:26 Exp $
 */
public interface PhAddressBrandRepository extends JpaRepository<PhAddressBrand,Long>,JpaSpecificationExecutor<PhAddressBrand> {

	/** 此处写一些自定义的方法 **/
}
