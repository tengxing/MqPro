package cn.littleterry.server;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费消息，消费到之后从队列中去除
 * @author terry
 * @since 02/02/2020
 */
public class QueueConsumer implements Runnable {
    public LinkedBlockingQueue<String> queue;
    public QueueConsumer(LinkedBlockingQueue<String> queue){
        this.queue = queue;
    }

    public void run() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
              /*if (!queue.isEmpty()){
                System.out.println("消费消息=====>"+queue.poll());
             }*/
            try {
                System.out.println("消费消息=====>"+queue.take());  //没有消息会等待，对应消息写入的put()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
