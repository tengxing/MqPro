package cn.littleterry.server;

import java.util.Date;
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

            //System.out.println("queue中的个数为："+queue.size());

            String data = queue.poll();
            if (data !=null){
                System.out.println("消费消息=====>"+data);
            }else {
                try {
                    Thread.sleep(1000*5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
