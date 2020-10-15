package com.wsq.test02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.wsq.test02.dao"})
public class MapperConfig {
}
