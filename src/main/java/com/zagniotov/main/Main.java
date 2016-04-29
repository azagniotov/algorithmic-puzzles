package com.zagniotov.main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        final HashSet<String> packagesToSkip = new HashSet<>(Arrays.asList("linguisticchains", "common"));
        final Set<String> classes = new ClassFinder("com.zagniotov.puzzles", packagesToSkip).find();
        final List<String> classNames = new ArrayList<>(classes);
        final int randomOffset = new Random().nextInt(classes.size());

        System.out.println("\n*******************************************************************************");
        System.out.println("** Your next practice puzzle is:\t{{>  " + classNames.get(randomOffset) + "  <}}");
        System.out.println("*******************************************************************************\n");
    }
}


