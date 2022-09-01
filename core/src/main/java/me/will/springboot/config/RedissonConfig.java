/*
 * Copyright (c) 2015-2020 BiliBili Inc.
 */

package me.will.springboot.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置
 *
 * @author willdu
 */
@Configuration
public class RedissonConfig {

  @Bean(name = "commonRedisson", destroyMethod = "shutdown")
  public RedissonClient commonRedisson() {
    var config = new Config();
    config.useSingleServer()
        .setAddress(String.format("redis://%s:%s", "192.168.1.9", 6379));
    return Redisson.create(config);
  }

}
