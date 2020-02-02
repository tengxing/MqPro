package cn.littleterry.server;

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
            queue.add(String.valueOf(i));
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产消息:"+ i);
        }
    }
}
