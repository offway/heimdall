package cn.offway.heimdall.service;

import java.util.List;
import java.util.Map;

import cn.offway.heimdall.domain.PhWardrobe;
import cn.offway.heimdall.utils.JsonResult;
import cn.offway.heimdall.domain.PhWardrobe;

/**
 * 衣柜Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
public interface PhWardrobeService{

	PhWardrobe save(PhWardrobe phWardrobe);
	
	PhWardrobe findOne(Long id);

	Map<String, Object> list(String unionid);

	JsonResult add(String unionid, Long goodsId, String color, String size, String useDate) throws Exception;

	void delete(Long id);

	void delInvalid(String unionid);

	Map<String, Object> list(List<Long> wrids);

	JsonResult addOrder(String unionid, Long[] wardrobeIds, Long addrId, String users) throws Exception;
}
