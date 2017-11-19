package com.db.test.redis.PubSub;

import redis.clients.jedis.Jedis;

public class Publisher  extends Thread{

    private final static String channel = "CCTV";

    @Override
    public void run() {
        Jedis jedis = new Jedis("localhost");
        int n = 0;
        try {
            while (true) {
                String message = "这是第"+n+++"条消息!";
                jedis.publish(channel, message);
                Thread.sleep(5000);
            }
        }catch (Exception e){
            System.out.println("发布者出错!");
        }
    }


    public static void main(String[] args)
    {
        new Publisher().start();
    }
}
