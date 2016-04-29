package com.zagniotov.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final Set<String> classes = new ClassFinder("com.zagniotov.puzzles").find();
        final List<String> classNames = new ArrayList<>(classes);
        final int randomOffset = new Random().nextInt(classes.size());
        System.out.println("\n*******************************************************************************");
        System.out.println("** Your next practice puzzle is:\t{{>  " + classNames.get(randomOffset) + "  <}}");
        System.out.println("*******************************************************************************\n");
    }
}


