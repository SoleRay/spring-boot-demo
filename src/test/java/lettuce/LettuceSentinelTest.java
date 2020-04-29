package lettuce;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.masterreplica.MasterReplica;
import io.lettuce.core.masterreplica.StatefulRedisMasterReplicaConnection;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LettuceSentinelTest {

    private static RedisURI sentinelUri;

    private static RedisURI standaloneUri;

//    @BeforeClass
    public static void buildSentinel() {
        sentinelUri = RedisURI.builder()
                .withSentinel("192.168.0.10",26379)
                .withSentinel("192.168.0.11",26379)
                .withSentinel("192.168.0.12",26379)
                .withSentinelMasterId("mymaster")
                .withPassword("redis123456")
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
    }

    @BeforeClass
    public static void buildStandalone() {
        standaloneUri = RedisURI.builder()
                .withHost("192.168.0.10")
                .withPort(6000)
                .withPassword("redis123456")
                .build();
    }

    @Test
    public void testStandalone(){
        RedisClient client = RedisClient.create(standaloneUri);
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCommands<String, String> commands = connection.sync();
        Long keys = commands.dbsize();
        System.out.println(keys);
    }

    /**
     * 哨兵 + 主从（读写分离）
     */
    @Test
    public void testSentinelAndReadFrom(){

        RedisClient client = RedisClient.create();

        StatefulRedisMasterReplicaConnection<String, String> connection = MasterReplica.connect(
                client,
                new StringCodec(),
                sentinelUri);

        connection.setReadFrom(ReadFrom.REPLICA);

        RedisCommands<String, String> commands = connection.sync();
        String value = commands.get("hello");// Replica read
        System.out.println(value);


        connection.close();
        client.shutdown();
    }

    /**
     * 哨兵 + 主从（无读写分离）
     */
    @Test
    public void testOnlySentinel(){
        RedisClient client = RedisClient.create(sentinelUri);
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCommands<String, String> commands = connection.sync();
        String value = commands.get("hello");
        System.out.println(value);
    }

}
