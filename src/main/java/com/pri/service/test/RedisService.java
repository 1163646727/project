package com.pri.service.test;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
	
	private StringRedisTemplate template;
	
	public RedisService(StringRedisTemplate template) {
		this.template = template;
	}

	/**
	 * methodName: redisTransactionTest <BR>
	 * description: springboot 集成redis事务测试<BR>
	 * remark: <BR>
	 * param:  <BR>
	 * return: void <BR>
	 * author: ChenQi <BR>
	 * createDate: 2020-07-21 18:55 <BR>
	 */
    @Transactional
    public void redisTransactionTest(){
        String result = "zhangsan123";
        template.opsForValue().set("user1", result);
        // int i = 1 / 0; // 模拟异常
        template.opsForValue().set("user2", result);
    }
}
