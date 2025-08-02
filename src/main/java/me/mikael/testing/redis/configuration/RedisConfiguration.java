package me.mikael.testing.redis.configuration;

import me.mikael.testing.redis.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Student> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // Add some specific configuration here. Key serializers, etc.
        return template;
    }
}
