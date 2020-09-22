package com.pri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class RedisConfiguration {

	@Bean
	public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		template.setEnableTransactionSupport(true);
		return template;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) throws SQLException {
	    return new DataSourceTransactionManager(dataSource);
    }
}
