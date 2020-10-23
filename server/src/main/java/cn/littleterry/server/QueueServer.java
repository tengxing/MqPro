package cn.littleterry.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author terry
 * @since 02/02/2020
 */
public class QueueServer{
    private static Queue<String> queue = new ConcurrentLinkedQueue<String>();

    public static void main(String[] args) {

        System.out.println("消息队列主线程已启动！");
        //生产者写入消息
        QueueProducer queueProducer = new QueueProducer(queue);
        Thread thread = new Thread(queueProducer);
        thread.start();

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        QueueConsumer consumer = new QueueConsumer(queue);
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
    }

}
