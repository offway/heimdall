package cn.offway.heimdall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.offway.heimdall.domain.PhGoodsProperty;

import java.util.List;

/**
 * 商品属性Repository接口
 *
 * @author tbw
 * @version $v: 1.0.0, $time:2019-12-09 13:28:39 Exp $
 */
public interface PhGoodsPropertyRepository extends JpaRepository<PhGoodsProperty,Long>,JpaSpecificationExecutor<PhGoodsProperty> {

    List<PhGoodsProperty> findByGoodsId(Long id);
}
