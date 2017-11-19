package com.db.test.redis.PubSub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends Thread{

    private final static String channel = "CCTV";

    @Override
    public void run() {
        Jedis jedis = new Jedis("localhost");
        jedis.subscribe(new MessageSub(),channel);
    }


    public static void main(String[] args)
    {
        new Subscriber().run();
    }


    class MessageSub  extends JedisPubSub{
        @Override
        public void onMessage(String channel, String message) {
            System.out.println("channel：  "+channel+"  message: "+message);
        }

        @Override
        public void onSubscribe(String channel, int subscribedChannels) {
            super.onSubscribe(channel, subscribedChannels);
        }

        @Override
        public void onUnsubscribe(String channel, int subscribedChannels) {
            super.onUnsubscribe(channel, subscribedChannels);
        }
    }
}
