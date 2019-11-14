package cn.offway.heimdall.service.impl;

import java.util.List;

import cn.offway.heimdall.service.PhAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.offway.heimdall.service.PhAddressService;

import cn.offway.heimdall.domain.PhAddress;
import cn.offway.heimdall.repository.PhAddressRepository;


/**
 * 地址管理Service接口实现
 *
 * @author wn
 * @version $v: 1.0.0, $time:2018-02-12 11:26:00 Exp $
 */
@Service
public class PhAddressServiceImpl implements PhAddressService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhAddressRepository phAddressRepository;
	
	@Override
	public PhAddress save(PhAddress phAddress){
		if("1".equals(phAddress.getIsDefault())){
			phAddressRepository.updatePhAddress(phAddress.getUnionid()); 
		}
		return phAddressRepository.save(phAddress);
	}
	
	@Override
	public void delete(Long id){
		phAddressRepository.delete(id);
	}
	
	@Override
	public PhAddress findOne(Long id){
		return phAddressRepository.findOne(id);
	}
	
	@Override
	public List<PhAddress> findByUnionid(String unionid){
		return phAddressRepository.findByUnionid(unionid);
	}
	
	@Override
	public  PhAddress findDefault(String unionid){
		List<PhAddress> phAddresses = phAddressRepository.findByUnionidAndIsDefault(unionid, "1");
		if(!phAddresses.isEmpty()){
			return phAddresses.get(0);
		}
		return null;
	}
}
