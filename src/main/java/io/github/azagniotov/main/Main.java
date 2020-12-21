package io.github.azagniotov.main;


import java.util.*;

public class Main {

    public static void main(final String[] args) {
        final HashSet<String> packagesToSkip = new HashSet<>(Arrays.asList(args[1].split(",")));
        final Set<String> classes = new ClassFinder(args[0], packagesToSkip).find();
        final List<String> classNames = new ArrayList<>(classes);
        final int randomOffset = new Random().nextInt(classes.size());

        System.out.println("\n*******************************************************************************");
        System.out.println("** Your next practice puzzle is:\t{{>  " + classNames.get(randomOffset) + "  <}}");
        System.out.println("*******************************************************************************\n");
    }
}


