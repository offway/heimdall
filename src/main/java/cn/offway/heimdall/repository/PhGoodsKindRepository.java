package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhGoodsKind;

import java.util.List;

/**
 * 商品种类Repository接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-30 10:53:07 Exp $
 */
public interface PhGoodsKindRepository extends JpaRepository<PhGoodsKind,Long>,JpaSpecificationExecutor<PhGoodsKind> {

	/** 此处写一些自定义的方法 **/

	List<PhGoodsKind> findByGoodsCategory(Long id);
}
