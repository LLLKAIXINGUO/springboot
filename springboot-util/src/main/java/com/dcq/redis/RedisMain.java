package com.dcq.redis;

import redis.clients.jedis.Jedis;

//使用jedis操作redis
public class RedisMain {
    public static void main(String[] args) {

        //获取redis连接
        Jedis jedis = new Jedis("127.0.0.1",6379);

        //Jedis操作
        //String类型
        jedis.set("name","林青霞");
        String name = jedis.get("name");
        System.out.println(name);

        //字符串
        // 1.string
        //输出结果: OK
        jedis.set("hello", "world");
        //输出结果: world
        jedis.get("hello");
        //输出结果:1
        jedis.incr("counter");

        //哈希
        // 2.hash
        jedis.hset("myhash", "f1", "v1");
        jedis.hset("myhash", "f2", "v2");
        //输出结果 : {f1=v1, f2=v2}
        jedis.hgetAll("myhash");

        //列表
        // 3.list
        jedis.rpush("mylist", "1");
        jedis.rpush("mylist", "2");
        jedis.rpush(" mylist", "3");
        //输出结果 : [1, 2, 3]
        jedis.lrange("mylist", 0, -1);

        //集合
        // 4.set
        jedis.sadd(" myset", "a");
        jedis.sadd(" myset", "b");
        jedis.sadd(" myset", "a");
        //输出结果 : [b, a]
        jedis.smembers("myset");
        //有序集合
        // 5.zset
        jedis.zadd("myzset", 99, "tom");
        jedis.zadd("myzset", 66, "peter");
        jedis.zadd("myzset", 33, "james");
        //输出结果 : [[["james"],33.0], [["peter"],66.0], [["tom"],99.0]]
        jedis.zrangeWithScores("myzset", 0, -1);

    }
}
