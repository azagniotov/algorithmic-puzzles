package linguistic_chains.printers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public final class StdOutPrinter {

    public void printExecutionTime(final long elapsed, final String actionDescription) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsed) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsed));
        final String duration = String.format(actionDescription + " took exactly: %d min, %d sec, %d millis",
                TimeUnit.MILLISECONDS.toMinutes(elapsed),
                seconds,
                TimeUnit.MILLISECONDS.toMillis(elapsed - TimeUnit.SECONDS.toMillis(seconds)));
        System.out.println(duration);
    }

    public void print(final List<String> chains) {
        for (final String chain : chains) {
            System.out.println(chain);
        }
        System.out.println("");
    }
}
