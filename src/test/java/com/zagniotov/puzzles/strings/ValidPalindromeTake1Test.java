package com.zagniotov.puzzles.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidPalindromeTake1Test {

    @Test
    public void testIsPalindrome() throws Exception {
        ValidPalindromeTake1 validPalindromeTake1 = new ValidPalindromeTake1();

        assertTrue(validPalindromeTake1.isPalindrome("Amore, Roma"));
        assertTrue(validPalindromeTake1.isPalindrome("Not so, Boston."));
        assertTrue(validPalindromeTake1.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(validPalindromeTake1.isPalindrome("Name sold, I'd lose man"));
        assertTrue(validPalindromeTake1.isPalindrome("A Santa dog lived as a devil God at NASA."));
        assertTrue(validPalindromeTake1.isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!"));
        assertTrue(validPalindromeTake1.isPalindrome("No 'x' in 'Nixon'"));
        assertTrue(validPalindromeTake1.isPalindrome("Are we not drawn onward, we few, drawn onward to new era?"));
        assertTrue(validPalindromeTake1.isPalindrome("Barge in! Relate mere war of 1991 for a were-metal Ernie grab!"));
        assertTrue(validPalindromeTake1.isPalindrome("eeeeeweeeee"));
        assertTrue(validPalindromeTake1.isPalindrome("a."));

        assertFalse(validPalindromeTake1.isPalindrome("race a car"));
        assertFalse(validPalindromeTake1.isPalindrome("0P"));
        assertFalse(validPalindromeTake1.isPalindrome(
                "v0 Nx56. !Gd!Q? C`C,\\\"I!Nq:H?l14\\\"?e4U..'R5Q:4N;`Vp\\\"?su;:\\\"i :71QH,?!y AUl " +
                        "FY `34e,V.P!\\\"WrW.8,yJQ4,'.T:O:33.a7K2OB.9E\nl7''g `4'bm.fc5'!l:9?8;WB?YV," +
                        "Z8yQ;43s34;Qy8Z,VY?BW;8?9:l!'5cf.mb'4` g'V7l ,E9.BO2K7a.33:O:T.',4QJy,8.WrW!" +
                        "P.',e43` YF lUA y!?,HQ17: i\\\":;us?\\\"pV`;N4:Q5R'..U4e?\\\"41l?H:qN!I\\\"," +
                        "C`C ?Q!dG! .65xN 0v"));
    }
}