package cn.littleterry.server;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产消息，每2秒生产一次数据
 * @author terry
 * @since 02/02/2020
 */
public class QueueProducer implements Runnable{
    public LinkedBlockingQueue<String> queue;
    public QueueProducer(LinkedBlockingQueue<String> queue){
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
            //queue.offer(data);
            try {
                queue.put(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产消息=>"+ data);
        }
    }
}
