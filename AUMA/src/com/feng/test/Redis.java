package com.feng.test;

import redis.clients.jedis.Jedis;

public class Redis {
	public static void main(String[] args) {
		 Jedis jedis = new Jedis("192.168.52.128", 6379);
		 System.out.println(jedis.ping());
		 System.out.println(jedis.get("name"));
	}

}
