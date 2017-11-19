package com.db.test.redis.queue;

public class QueueProducer  extends Thread{
    public static byte[] redisKey = "key".getBytes();

    @Override
    public void run() {
        int n = 0;
        try{
            while(true){
                Message message = new Message(n, "这是第" + n + "个内容");
                JedisUtil.lpush(redisKey, ObjectSerialize.object2Bytes(message));
                n++;
                Thread.sleep(5000);
            }
        }catch (Exception e){
            System.out.println("-----------------生产者异常!-----------------");
        }
    }

    public static void main(String[] args)
    {
        new QueueProducer().start();
    }
}
