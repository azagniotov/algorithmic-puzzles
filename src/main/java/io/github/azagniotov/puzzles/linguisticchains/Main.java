package io.github.azagniotov.puzzles.linguisticchains;

import io.github.azagniotov.puzzles.linguisticchains.graph.Graph;
import io.github.azagniotov.puzzles.linguisticchains.io.InputReader;
import io.github.azagniotov.puzzles.linguisticchains.printers.StdOutPrinter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            //System.err.println("Usage: java -jar linguistic-chains-1.0.0.jar <input file name>");
            //System.exit(1);
        } else {
            final StdOutPrinter stdOutPrinter = new StdOutPrinter();

            final long startReading = System.currentTimeMillis();
            try {
                final Map<Integer, Set<String>> wordsByLength = new InputReader().loadDictionary(args[0]);
                final long endReading = System.currentTimeMillis();

                final Graph graph = new Graph(wordsByLength);

                final long startComputing = System.currentTimeMillis();
                final List<String> chains = graph.compute();
                final long endComputing = System.currentTimeMillis();

                stdOutPrinter.print(chains);

                stdOutPrinter.printExecutionTime(endReading - startReading, "Loading the dictionary");
                stdOutPrinter.printExecutionTime(endComputing - startComputing, "Computing word tree & longest chains");
            } catch (IOException ex) {
                System.err.println("Error: file " + args[0] + " does not exist. Please check the file name and try again");
                System.exit(1);
            }
        }
    }
}
