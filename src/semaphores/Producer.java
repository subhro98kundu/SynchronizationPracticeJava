package semaphores;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;
    private Queue<Shirt> shirts;
    public Producer(Queue<Shirt> shirts, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.shirts = shirts;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    private void addShirt() throws InterruptedException {
        producerSemaphore.acquire();
        shirts.add(new Shirt());
        System.out.println("Shirt List Size: " + shirts.size() + ". Producer "
                + Thread.currentThread().getName() + " added a shirt.");
        consumerSemaphore.release();
    }
    @Override
    public void run() {
        while(true) {
            try {
                this.addShirt();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
