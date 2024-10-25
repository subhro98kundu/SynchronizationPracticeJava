import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int x = 10;
    static void display(){
        System.out.println("Displaying");
    }
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count(0);
//        ReentrantLock mutex = new ReentrantLock();
//        Adder adder = new Adder(count, mutex);
//        Substractor substractor = new Substractor(count, mutex);
        Adder adder = new Adder(count);
        Substractor substractor = new Substractor(count);
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(substractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.getCount());
//        Main m = new Main();
//        Main m2 = new Main();
//        m.x = 20;
//        System.out.println(m.x + " " + m2.x);
//        m.display();
    }
}
