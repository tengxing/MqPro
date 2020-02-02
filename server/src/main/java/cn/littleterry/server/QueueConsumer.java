package cn.littleterry.server;

import java.util.Queue;

/**
 * 消费消息，消费到之后从队列中去除
 * @author terry
 * @since 02/02/2020
 */
public class QueueConsumer implements Runnable {
    public Queue<String> queue;
    public QueueConsumer(Queue<String> queue){
        this.queue = queue;
    }

    public void run() {
        while (true){
            String data = queue.peek();
            if (data !=null){

                System.out.println("消费消息:"+ data);
                queue.poll();
            }
        }
    }
}
