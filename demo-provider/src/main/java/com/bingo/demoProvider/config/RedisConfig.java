package com.bingo.demoProvider.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class RedisConfig {

  public static final String ACTION = "action:";

  public static final String USER = ACTION + "user";

}
