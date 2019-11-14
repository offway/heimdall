package cn.offway.heimdall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.offway.heimdall.domain.PhAuth;
import cn.offway.heimdall.domain.PhCode;
import cn.offway.heimdall.properties.QiniuProperties;
import cn.offway.heimdall.repository.PhAuthRepository;
import cn.offway.heimdall.service.PhAuthService;
import cn.offway.heimdall.service.PhCodeService;
import cn.offway.heimdall.service.PhUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.offway.heimdall.domain.PhAuth;
import cn.offway.heimdall.domain.PhCode;
import cn.offway.heimdall.domain.PhUserInfo;
import cn.offway.heimdall.dto.AuthDto;
import cn.offway.heimdall.properties.QiniuProperties;
import cn.offway.heimdall.repository.PhAuthRepository;
import cn.offway.heimdall.service.PhAuthService;
import cn.offway.heimdall.service.PhCodeService;
import cn.offway.heimdall.service.PhUserInfoService;
import cn.offway.heimdall.utils.CommonResultCode;
import cn.offway.heimdall.utils.JsonResult;
import cn.offway.heimdall.utils.JsonResultHelper;


/**
 * 用户认证Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
@Service
public class PhAuthServiceImpl implements PhAuthService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhAuthRepository phAuthRepository;
	
	@Autowired
	private JsonResultHelper jsonResultHelper;
	
	@Autowired
	private PhUserInfoService phUserInfoService;
	
	@Autowired
	private PhCodeService phCodeService;
	
	@Autowired
	private QiniuProperties qiniuProperties;
	
	@Override
	public PhAuth save(PhAuth phAuth){
		return phAuthRepository.save(phAuth);
	}
	
	@Override
	public PhAuth findOne(Long id){
		return phAuthRepository.findOne(id);
	}
	
	@Override
	public PhAuth findByUnionid(String unionid){
		return phAuthRepository.findByUnionid(unionid);
	}
	
	@Override
	public int countByUnionidAndStatusIn(String unionid,List<String> status){
		return phAuthRepository.countByUnionidAndStatusIn(unionid, status);
	}
	
	@Override
	public JsonResult auth(AuthDto authDto){

		PhCode phCode = phCodeService.findByCodeAndStatusAndPhoneAndRealName(authDto.getCode(), "0", authDto.getPhone(), authDto.getRealName());
		if(null == phCode){
			//邀请码无效
			return jsonResultHelper.buildFailJsonResult(CommonResultCode.CODE_ERROR);
		}
		
		
		PhAuth phAuth = new PhAuth();
		BeanUtils.copyProperties(authDto, phAuth);
		
		
		phAuth.setCodeId(phCode.getId());;
		phAuth.setIdcardObverse(qiniuProperties.getUrl()+"/"+phAuth.getIdcardObverse());
		phAuth.setIdcardPositive(qiniuProperties.getUrl()+"/"+phAuth.getIdcardPositive());
		phAuth.setInCert(qiniuProperties.getUrl()+"/"+phAuth.getInCert());
		
		String unionid = phAuth.getUnionid();
		List<String> status = new ArrayList<>();
		status.add("0");
		status.add("1");
		int count = countByUnionidAndStatusIn(unionid, status);
		if(count==0){
			PhUserInfo phUserInfo = phUserInfoService.findByUnionid(unionid);
			phAuth.setNickname(phUserInfo.getNickname());
			phAuth.setHeadimgurl(phUserInfo.getHeadimgurl());
			phAuth.setCreateTime(new Date());
			phAuth.setStatus("0");
			save(phAuth);
			
			phCode.setStatus("1");
			phCodeService.save(phCode);
		}
		
		return jsonResultHelper.buildSuccessJsonResult(null);
	}
	
}
