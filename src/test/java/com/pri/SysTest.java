package com.pri;

import com.pri.entity.SysUser;
import com.pri.entity.TestUser;
import com.pri.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: SysTest
 * @Description:
 * @auther: Chenqi
 * @Date: 2019/4/28 15:53
 * @Version 1.0 jdk1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysTest {


   // @Autowired
    //private RedisService redisService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserService userService;

    /**
     *@MethodName:  loginTest
     *@Description:  根据用户名和密码查询
     *@Param: []
     *@Return: void
     *@author: ChenQi
     *@CreateDate: 2019/4/28 15:59
     */
    @Test
    public void loginTest(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword("123");
        sysUser.setNid("2");
       // SysUser sys = sysService.selectByNameAndPassword(sysUser);
       // System.out.println(sys);
    }

    @Test
    public void redisSetTest(){
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        set.add("set1","22");
        set.add("set1","33");
        set.add("set1","44");
        Set<String> resultSet =stringRedisTemplate.opsForSet().members("set1");
        System.out.println("resultSet:"+resultSet);
        //stringRedisTemplate.expire(  )
    }

    /**
     * methodName: redisSetStringTest <BR>
     * description: 测试并发操作redis <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-04-21 16:23 <BR>
     */
    @Test
    public void redisSetStringTest(){
        System.out.println("主线程开始...");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<10;i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        redisTemplate.opsForSet().add("test","test"+temp);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
                }
            });
        }
        // 主线程等待线程池 ChenQi;
        executorService.shutdown();
        try {
            // awaitTermination返回false即超时会继续循环，
            // 返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔2秒循环一次
            while (!executorService.awaitTermination(2, TimeUnit.SECONDS));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束...");
    }

    @Test
    public void redisSetStringTest2(){
        Jedis jedis =new Jedis("127.0.0.1",6379);
        System.out.println("redis连接成功");
        System.out.println(jedis.ping());

        jedis.del("test");
        jedis.set("test","test");
        jedis.set("test","test2");
    }

    @Test
    public void redisHashTest(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        redisTemplate.opsForHash().putAll("map1",map);

        Map<Object, Object> resultMap= redisTemplate.opsForHash().entries("map1");

        List<Object> reslutMapList=redisTemplate.opsForHash().values("map1");

        Set<Object> resultMapSet=redisTemplate.opsForHash().keys("map1");

        String value=(String)redisTemplate.opsForHash().get("map1","key1");

        System.out.println("value:"+value);
        System.out.println("resultMapSet:"+resultMapSet);
        System.out.println("resultMap:"+resultMap);
        System.out.println("resulreslutMapListtMap:"+reslutMapList);
        System.out.println();
    }

    @Test
    public void redisApi(){
        String redisKey = "user_2_2";
        //redisTemplate.opsForValue().set(redisKey,"value1");
        String result1=redisTemplate.opsForValue().get(redisKey)==null?null:redisTemplate.opsForValue().get(redisKey).toString();
        System.out.println(result1);
        /*ChenQi 2019/5/31 0031;*/
        /**
         *
         * */
    }

    /**
     *@MethodName:  addUserList
     *@Description: 测试批量插入
     *@Param: []
     *@Return: void
     *@Author: ChenQi
     *@CreateDate: 2019/7/14 0014 下午 10:13
     */
    @Test
    public void addUserList(){
        List<TestUser> testUsers = new ArrayList<>();
        TestUser testUser = new TestUser();
        testUser.setName("test1");
        testUser.setAge(21);
        TestUser testUser2 = new TestUser();
        testUser2.setName("test2");
        testUser2.setAge(22);
        testUsers.add(testUser);
        testUsers.add(testUser2);
        int i = userService.testAddUserList(testUsers);
        System.out.println(i);
    }
    //测试mybatis多条件批量删除 ChenQi;
    @Test
    public void delUserList(){
        List<TestUser> testUsers = new ArrayList<>();
        TestUser testUser = new TestUser();
        testUser.setUid(14);
        testUser.setName("test1");
        testUser.setAge(21);
        TestUser testUser2 = new TestUser();
        testUser2.setUid(15);
        testUser2.setName("test2");
        testUser2.setAge(22);
        testUsers.add(testUser);
        testUsers.add(testUser2);
        int i = userService.testDelUserList(testUsers);
        System.out.println(i);
    }



    //批量插入数据，数据存在时更新，不存在时插入 ChenQi;
    @Test
    public void testAddUserListOrIgnore(){
        List<TestUser> testUsers = new ArrayList<>();
        TestUser testUser = new TestUser();
        testUser.setName("test1");
        testUser.setSex("男");
        testUser.setAge(22);
        TestUser testUser2 = new TestUser();
        testUser2.setName("test2");
        testUser2.setSex("男");
        testUser2.setAge(22);
        TestUser testUser3 = new TestUser();
        testUser3.setName("test3");
        testUser3.setSex("女");
        testUser3.setAge(22);
        testUsers.add(testUser);
        testUsers.add(testUser2);
        testUsers.add(testUser3);
        int i = userService.testAddUserListOrIgnore(testUsers);
        System.out.println(i);
    }

    /**
     * methodName: deleteLoginById <BR>
     * description: 测试xml和注解这两种方式生成sql语句的效率<BR>
     * remark: 注解版效率高些，打印结果如下<BR>
     *     xml动态生成sql耗时：352<BR>
     *     注解动态生成sql耗时：31<BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-04-14 14:33 <BR>
     */
    @Test
    public void deleteLoginById(){
        Integer id = 11;
        Long start = System.currentTimeMillis();
        userService.deleteLoginById(id);
        Long end = System.currentTimeMillis();
        System.out.println("xml动态生成sql耗时："+(end-start));
        start = System.currentTimeMillis();
        userService.deleteLoginById_2(id);
        end = System.currentTimeMillis();
        System.out.println("注解动态生成sql耗时："+(end-start));
    }


}
