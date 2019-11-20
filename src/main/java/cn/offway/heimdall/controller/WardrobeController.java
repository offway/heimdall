package cn.offway.heimdall.controller;

import cn.offway.heimdall.domain.PhWardrobe;
import cn.offway.heimdall.domain.PhWardrobeAudit;
import cn.offway.heimdall.service.PhWardrobeAuditService;
import cn.offway.heimdall.service.PhWardrobeService;
import cn.offway.heimdall.utils.CommonResultCode;
import cn.offway.heimdall.utils.JsonResult;
import cn.offway.heimdall.utils.JsonResultHelper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 衣柜
 * @author wn
 *
 */
@RestController
@RequestMapping("/wardrobe")
public class WardrobeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JsonResultHelper jsonResultHelper;
	
	@Autowired
	private PhWardrobeService phWardrobeService;

	@Autowired
	private PhWardrobeAuditService phWardrobeAuditService;
	
	@ApiOperation(value="加入衣柜",notes="返回码：200=成功； 1009=衣柜调价衣物以至8件上限；1010=您的信用分太低，不能再借衣服；1011=您有一批订单反馈图未上传，上传后即可借衣；1012=有一笔订单未归还")
	@PostMapping("/add")
	public JsonResult add(@ApiParam("unionid") @RequestParam String unionid,
			@ApiParam("商品ID") @RequestParam Long goodsId,
			@ApiParam("颜色") @RequestParam String color,
			@ApiParam("尺码") @RequestParam String size,
			@ApiParam("使用日期,格式yyyy-MM-dd") @RequestParam String useDate) throws Exception{
		
		return phWardrobeService.add(unionid, goodsId, color, size, useDate);
	}
	
	@ApiOperation("衣柜列表")
	@GetMapping("/list")
	public JsonResult list(@ApiParam("unionid") @RequestParam String unionid){
		
		return jsonResultHelper.buildSuccessJsonResult(phWardrobeService.list(unionid));
	}

	@ApiOperation("申请使用")
	@GetMapping("/audit")
	public JsonResult audit(@ApiParam("unionid") @RequestParam String unionid,
							@ApiParam("商品ID") @RequestParam Long goodsId,
							@ApiParam("颜色") @RequestParam String color,
							@ApiParam("尺码") @RequestParam String size,
							@ApiParam("使用日期,格式yyyy-MM-dd") @RequestParam String useDate,
							@ApiParam("使用艺人") @RequestParam String useName,
							@ApiParam("使用用途") @RequestParam String content,
							@ApiParam("归还时间") @RequestParam String returnDate,
							@ApiParam("返图时间") @RequestParam String photoDate) throws ParseException {
		phWardrobeAuditService.add(unionid,goodsId,color,size,useDate,useName,content,returnDate,photoDate);
		return jsonResultHelper.buildSuccessJsonResult(null);
	}

	@ApiOperation("查询状态")
	@PostMapping("/auditState")
	public JsonResult auditState(@ApiParam("unionid") @RequestParam String unionid,
								 @ApiParam("状态[0-待审核,1-审核通过,2-审核不通过]") @RequestParam String state){
		return jsonResultHelper.buildSuccessJsonResult(phWardrobeService.findState(unionid,state));
	}

	@ApiOperation("确认订单-查询衣柜")
	@GetMapping("/listByIds")
	public JsonResult wardrobelist(@ApiParam("衣柜ID,多个用逗号隔开") @RequestParam String wardrobeIds){
		
		List<String> a =  Arrays.asList(wardrobeIds.split(","));
		List<Long> b = new ArrayList<>();
		for (String s : a) {
			b.add(Long.parseLong(s));
		}
		return jsonResultHelper.buildSuccessJsonResult(phWardrobeService.list(b));
	}
	
	@ApiOperation("删除")
	@PostMapping("/del")
	public JsonResult del(@ApiParam("衣柜ID") @RequestParam Long wardrobeId) throws Exception{
		phWardrobeService.delete(wardrobeId);
		return jsonResultHelper.buildSuccessJsonResult(null);
	}
	
	@ApiOperation("清除失效物件")
	@PostMapping("/delInvalid")
	public JsonResult delInvalid(@ApiParam("unionid") @RequestParam String unionid) throws Exception{
		phWardrobeService.delInvalid(unionid);
		return jsonResultHelper.buildSuccessJsonResult(null);
	}
	
	@ApiOperation("下订单")
	@PostMapping("/addOrder")
	public JsonResult addOrder(
			@ApiParam("unionid") @RequestParam String unionid,
			@ApiParam("衣柜ID") @RequestParam Long[] wardrobeIds,
			@ApiParam("地址ID") @RequestParam Long addrId,
			@ApiParam("使用者") @RequestParam String users){
		
		try {
			return phWardrobeService.addOrder(unionid,wardrobeIds, addrId, users);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("下订单异常，unionid:{},wardrobeIds:{},addrId:{},users:{}",unionid,wardrobeIds, addrId, users,e);
			if("减库存失败".equals(e.getMessage())){
				return jsonResultHelper.buildFailJsonResult(CommonResultCode.UPDATE_STOCK_ERROR);
			}else{
				return jsonResultHelper.buildFailJsonResult(CommonResultCode.SYSTEM_ERROR);
			}
		}
	}

	@ApiOperation("修改使用时间")
	@PostMapping("/deitByIds")
	public JsonResult deitByIds(@ApiParam("衣柜ID,多个用逗号隔开") @RequestParam String wardrobeIds,@ApiParam("使用日期,格式yyyy-MM-dd") @RequestParam String useDate) throws ParseException {
		List<String> a =  Arrays.asList(wardrobeIds.split(","));
		for (String s : a) {
			PhWardrobe wardrobe = phWardrobeService.findOne(Long.valueOf(s));
			wardrobe.setUseDate(DateUtils.parseDate(useDate, "yyyy-MM-dd"));
			phWardrobeService.save(wardrobe);
		}
		return jsonResultHelper.buildFailJsonResult(CommonResultCode.SUCCESS);
	}
	
}
