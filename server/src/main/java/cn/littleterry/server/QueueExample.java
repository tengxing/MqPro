package cn.littleterry.server;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 *
 *
 * @author terry
 * @since 02/02/2020
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue();
        for (int i = 0;i<10;i++){
            queue.add(i);
            System.out.println(queue);
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }
        System.out.println(queue);
        System.out.println(queue);
    }
}
