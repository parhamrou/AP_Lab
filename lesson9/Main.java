import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            eService.execute(new Filehandler(i + 1));
        }
        eService.shutdown();
        try {
            eService.awaitTermination(3000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(eService.isTerminated());
        Filehandler.printResult();
    }
}
