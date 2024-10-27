import exceptions.OperationNotAllowedException;

import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {
    private Count count;
    private ReentrantLock mutex;
    public Adder(Count count, ReentrantLock mutex){
        this.count = count;
        this.mutex = mutex;
    }
    public Adder(Count count) {
        this.count  = count;
    }

    @Override
    public void run() {
        for(int i = 0; i<100; i++){
//            this.mutex.lock();
//            synchronized (count) {
            try {
                this.count.changeCount('+');
            } catch (OperationNotAllowedException e) {
                throw new RuntimeException(e);
            }
//            }
//            this.mutex.unlock();
        }
    }
}
