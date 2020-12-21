package io.github.azagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CountWordsInStringTake1Test {

    @Test
    public void testCountWords() throws Exception {
        CountWordsInStringTake1 countWordsInString = new CountWordsInStringTake1();

        assertEquals(0, countWordsInString.countWords(""));
        assertEquals(1, countWordsInString.countWords("Hello"));
        assertEquals(2, countWordsInString.countWords("Hello world!"));
        assertEquals(4, countWordsInString.countWords("Hello world! It's fun!"));
        assertEquals(13, countWordsInString.countWords("how ma ny wo rds are th ere in th is sente nce"));
    }

    @Test
    public void testCountUniqueWords() throws Exception {
        CountWordsInStringTake1 countWordsInString = new CountWordsInStringTake1();

        assertEquals(0, countWordsInString.countUniqueWords(""));
        assertEquals(1, countWordsInString.countUniqueWords("Hello"));
        assertEquals(2, countWordsInString.countUniqueWords("Hello world!"));
        assertEquals(4, countWordsInString.countUniqueWords("Hello world! It's fun!"));
        assertEquals(12, countWordsInString.countUniqueWords("how ma ny wo rds are th ere in th is sente nce"));

        assertEquals(2, countWordsInString.countUniqueWords("Hello hello world!"));
        assertEquals(2, countWordsInString.countUniqueWords("Hello world world!"));
        assertEquals(2, countWordsInString.countUniqueWords("Hello world world!!!!!!!!!!!!!!!"));
        assertEquals(3, countWordsInString.countUniqueWords("Hello world, world... Agreed, hello, World!"));
    }
}