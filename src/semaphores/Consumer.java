package semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;
    private Queue<Shirt> shirts;
    public Consumer(Queue<Shirt> shirts, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.shirts = shirts;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    private void consumeShirt() throws InterruptedException {
        consumerSemaphore.acquire();
        shirts.poll();
        System.out.println("Shirt List Size: " + shirts.size() + ". Consumer "
                + Thread.currentThread().getName() + " bought a shirt.");
        producerSemaphore.release();
    }
    @Override
    public void run() {
        while(true) {
            try {
                this.consumeShirt();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
