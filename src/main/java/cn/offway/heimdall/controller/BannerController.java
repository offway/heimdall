package cn.offway.heimdall.controller;

import cn.offway.heimdall.service.PhBannerService;
import cn.offway.heimdall.utils.JsonResult;
import cn.offway.heimdall.utils.JsonResultHelper;
import cn.offway.heimdall.service.PhBannerService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JsonResultHelper jsonResultHelper;

    @Autowired
    private PhBannerService phBannerService;

    @ApiOperation("banner列表")
    @GetMapping("/list")
    public JsonResult list() {
        return jsonResultHelper.buildSuccessJsonResult(phBannerService.findAll());
    }
}