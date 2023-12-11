package com.ragtag.X10.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ragtag.X10.model.dao")
public class DBConfig {
}
