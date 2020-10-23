package cn.littleterry.server;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** 先进先出顺序消费
 * @author terry
 * @since 02/02/2020
 */
public class QueueServer{
    private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

    public static void main(String[] args) {

        System.out.println("消息队列主线程已启动！");
        //生产者写入消息
        QueueProducer queueProducer = new QueueProducer(queue);
        Thread thread = new Thread(queueProducer);
        thread.start();


        QueueConsumer consumer = new QueueConsumer(queue);
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
    }

}
