package cn.littleterry.server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author terry
 * @since 02/02/2020
 */
public class QueueServer {
    private static Queue<String> queue;

    public static void main(String[] args) {
        queue = new ConcurrentLinkedQueue<String>();
        System.out.println("消息队列主线程已启动！");

        QueueProducer producer = new QueueProducer(queue);
        Thread thread = new Thread(producer);
        thread.start();
        QueueConsumer consumer = new QueueConsumer(queue);
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
        while (queue.size()<=10000){
            //System.out.println(queue);
        }
    }
}
