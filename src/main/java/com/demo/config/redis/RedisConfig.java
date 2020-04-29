package com.demo.config.redis;

import com.demo.bean.redis.ByteRedisTemplate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.masterreplica.StatefulRedisMasterReplicaConnection;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class RedisConfig {

    /**
     *
     * RedisAutoConfiguration中有默认的配置
     * 如果需要强化，则可以在这里进行覆盖
     *
     */

    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer(){

        return clientConfigurationBuilder ->{
            clientConfigurationBuilder.readFrom(ReadFrom.REPLICA);
        };

    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        Jackson2JsonRedisSerializer jacksonSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//        om.activateDefaultTyping(null,ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSerializer.setObjectMapper(om);

        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(jacksonSerializer);

        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(jacksonSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        template.afterPropertiesSet();

        return template;
    }

    /**
     * 用户存取二进制的value
     */
    @Bean
    public ByteRedisTemplate byteRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new ByteRedisTemplate(redisConnectionFactory);
    }


    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        return cacheManager;
    }

    /**
     * 下面的方式也是可以的，但spring-data-redis，提供了Customizer的入口。
     * 其实最关键的就是LettuceClientConfiguration要设置readFrom
     *
     */

//    private RedisProperties redisProperties;
//
//    public RedisConfig(RedisProperties redisProperties) {
//        this.redisProperties = redisProperties;
//    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
//                .readFrom(ReadFrom.REPLICA)
//                .build();
//
//        return new LettuceConnectionFactory(getSentinelConfig(),clientConfig);
//    }
//
//    public RedisSentinelConfiguration getSentinelConfig(){
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("192.168.0.10", 26379)
//                .sentinel("192.168.0.11", 26379)
//                .sentinel("192.168.0.12", 26379);
//        sentinelConfig.setPassword("redis123456");
//        return sentinelConfig;
//    }

//
//    protected final RedisSentinelConfiguration getSentinelConfig() {
//
//        RedisProperties.Sentinel sentinelProperties = this.redisProperties.getSentinel();
//        if (sentinelProperties != null) {
//            RedisSentinelConfiguration config = new RedisSentinelConfiguration();
//            config.master(sentinelProperties.getMaster());
//            config.setSentinels(createSentinels(sentinelProperties));
//            if (this.redisProperties.getPassword() != null) {
//                config.setPassword(RedisPassword.of(this.redisProperties.getPassword()));
//            }
//            config.setDatabase(this.redisProperties.getDatabase());
//            return config;
//        }
//        return null;
//    }
//
//    private List<RedisNode> createSentinels(RedisProperties.Sentinel sentinel) {
//        List<RedisNode> nodes = new ArrayList<>();
//        for (String node : sentinel.getNodes()) {
//            try {
//                String[] parts = StringUtils.split(node, ":");
//                Assert.state(parts.length == 2, "Must be defined as 'host:port'");
//                nodes.add(new RedisNode(parts[0], Integer.valueOf(parts[1])));
//            }
//            catch (RuntimeException ex) {
//                throw new IllegalStateException("Invalid redis sentinel property '" + node + "'", ex);
//            }
//        }
//        return nodes;
//    }
}
