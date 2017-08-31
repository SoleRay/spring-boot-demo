1.application.yml和application-{profile}.properties两者选其一
2.mybatis选通用mybatis
3.用sprign-data-redis集成redis的时候，默认会使用Jedis作为实现
4.摒弃Date,统一使用LocalDate，LocalDateTime，所以增加了mybatis和jackson的相关支持
5.LocalDate，LocalDateTime的入参使用@DateTimeFormat标记，出参使用@JsonFormat标记（注意时区）
6.