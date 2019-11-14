package cn.offway.heimdall.config;

import cn.offway.heimdall.properties.QiniuProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import cn.offway.heimdall.properties.QiniuProperties;


@Configuration
@EnableConfigurationProperties(QiniuProperties.class)
public class QiniuConfig {

}
