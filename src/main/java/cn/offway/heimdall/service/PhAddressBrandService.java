package cn.offway.heimdall.service;


import java.util.List;

import cn.offway.heimdall.domain.PhAddressBrand;

/**
 * 品牌地址管理Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-11-30 10:53:07 Exp $
 */
public interface PhAddressBrandService{

    PhAddressBrand save(PhAddressBrand phAddressBrand);
	
    PhAddressBrand findOne(Long id);

    void delete(Long id);

    List<PhAddressBrand> save(List<PhAddressBrand> entities);
}
