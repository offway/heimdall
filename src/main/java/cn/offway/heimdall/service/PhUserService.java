package cn.offway.heimdall.service;


import cn.offway.heimdall.domain.PhUser;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;
import cn.offway.heimdall.dynamic.DS;
import cn.offway.heimdall.dynamic.DataSourceNames;

import java.util.List;

/**
 * 用户信息Service接口
 *
 * @author wn
 * @version $v: 1.0.0, $time:2019-10-30 14:38:27 Exp $
 */
public interface PhUserService {

    PhUser save(PhUser phUser);

    PhUser findOne(Long id);

    void delete(Long id);

    List<PhUser> save(List<PhUser> entities);

    PhUser findByUnionid(String unionid);

    PhUser findByPhone(String phone);

    @DS(DataSourceNames.BK)
    PhUser registered(String phone, String unionid, String nickName,
                      String headimgurl, long id);

    @DS(DataSourceNames.BK)
    int getMaxUserId();
}
