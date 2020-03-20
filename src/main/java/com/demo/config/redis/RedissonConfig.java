package com.demo.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * redisson 配置类
 * Created on 2018/6/19
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

//    @Value("${spring.redis.slave.addresses}")
//    private String slaveAddress;

    @Value("${spring.redis.sentinel.master}")
    private String sentinelMasterName;

    @Value("${spring.redis.sentinel.nodes}")
    private List<String> sentinelNodes;

    @Bean
    public RedissonClient getRedisson() {

        String masterAddress = "redis://" + host + ":" + port;

        Config config = new Config();

        //单Redis
//        config.useSingleServer().setAddress(masterAddress).setPassword(password);

        //Redis主从
//        config.useMasterSlaveServers().setMasterAddress(masterAddress).setPassword(password).addSlaveAddress(slaveAddress.split(","));

        //Redis-sentinel
        config.setLockWatchdogTimeout(10000).useSentinelServers().setMasterName(sentinelMasterName).setPassword(password).addSentinelAddress(sentinelNodes.stream().map(sentinelNode -> {
            return "redis://" + sentinelNode;
        }).collect(Collectors.toList()).toArray(new String[sentinelNodes.size()]));

        return Redisson.create(config);
    }

}