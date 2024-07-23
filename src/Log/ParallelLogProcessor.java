package Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelLogProcessor {
    private final ExecutorService executorService;

    public ParallelLogProcessor(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    public int processLogs(List<String> logFiles, String word) {
        List<Future<Integer>> futures = new ArrayList<>();
        for (String filePath : logFiles) {
            futures.add(executorService.submit(new LogProcessor(filePath, word)));
        }

        int totalOccurrences = 0;
        for (Future<Integer> future : futures) {
            try {
                totalOccurrences += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return totalOccurrences;
    }
}
