package cn.offway.heimdall.config;

import cn.offway.heimdall.properties.WxpayProperties;
import cn.offway.heimdall.properties.WxpayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WxpayProperties.class)
public class WxpayConfig {
}
