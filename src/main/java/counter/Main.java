package counter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();
        SimpleCounter simpleCounter = new SimpleCounter();

        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(simpleCounter, i);
            thread.start();
            threadList.add(thread);
        }
        System.out.println("For loop completed");

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Counter = " + simpleCounter.get());
    }
}
