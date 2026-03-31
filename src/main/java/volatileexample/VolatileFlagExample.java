package volatileexample;

/*
Есть основной поток - main
Есть второй поток - worker, делает что-то
нужно сказать из одного потока, чтобы worker остановился
*/
public class VolatileFlagExample {

    private static boolean running = true;

    static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker start");
            while(running){
                int x = 0;
                for (int i = 0; i < 1000; i++) {
                    x++;
                }
            }
        });
        worker.start();


        Thread.sleep(2000);
        System.out.println("Main: request to stop worker");
        running = false;

        worker.join();
        System.out.println("Main: finish");
    }
}
