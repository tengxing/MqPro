package cn.littleterry.server;

import java.util.Date;
import java.util.Queue;

/**
 * 生产消息，每2秒生产一次数据
 * @author terry
 * @since 02/02/2020
 */
public class QueueProducer implements Runnable{
    public Queue<String> queue;
    public QueueProducer(Queue<String> queue){
        this.queue = queue;
    }
    public void run() {
        for (int i=0;i<Integer.MAX_VALUE;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String data = String.format("{'id':'%s'}",i );
            queue.add(data);
            System.out.println("生产消息=>"+ data);
        }
    }
}
