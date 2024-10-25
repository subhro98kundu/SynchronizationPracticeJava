import java.util.concurrent.locks.ReentrantLock;

public class Substractor implements Runnable {
    private Count count;
    private ReentrantLock mutex;
    public Substractor(Count count, ReentrantLock mutex){
        this.count = count;
        this.mutex = mutex;
    }
    public Substractor(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 0; i<100; i++) {
//            this.mutex.lock();
//            synchronized (Count.class) {
            try {
                this.count.changeCount('-');
            } catch (OperationNotAllowedException e) {
                throw new RuntimeException(e);
            }
//            }
//            this.mutex.unlock();
        }
    }
}
