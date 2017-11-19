package com.db.test.redis.queue;

public class QueueConsumer  extends Thread{
    public static byte[] redisKey = "key".getBytes();

    @Override
    public void run() {
        int n = 0;
        try{
            while(true){
                byte[] bytes = JedisUtil.rpop(redisKey);
                if (bytes != null) {
                    Message msg = (Message) ObjectSerialize.bytes2Object(bytes);
                    System.out.println(msg.getId() + "----" + msg.getContent());
                }
            }
        }catch (Exception e){
            System.out.println("-----------------消费者异常!-----------------");
        }
    }

    public static void main(String[] args)
    {
         new QueueConsumer().start();
    }
}
