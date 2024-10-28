package semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Queue<Shirt> shirts = new ConcurrentLinkedQueue<>();
        Semaphore producerSema = new Semaphore(5);
        Semaphore consumerSema = new Semaphore(0);
        Thread producer1 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer2 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer3 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer4 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer5 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer6 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer7 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer8 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer9 = new Thread(new Producer(shirts, producerSema, consumerSema));
        Thread producer10 = new Thread(new Producer(shirts, producerSema, consumerSema));

        Thread consumer1 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer2 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer3 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer4 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer5 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer6 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer7 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer8 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer9 = new Thread(new Consumer(shirts, producerSema, consumerSema));
        Thread consumer10 = new Thread(new Consumer(shirts, producerSema, consumerSema));

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
        consumer7.start();
        consumer8.start();
        consumer9.start();
        consumer10.start();

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();
        producer7.start();
        producer8.start();
        producer9.start();
        producer10.start();
    }

}
