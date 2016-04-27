package com.zagniotov.puzzles.bitwise;

public class CountingOneBitsTake1 {

    CountingOneBitsTake1() {

    }

    /**
     * The simplest technique is right-shift the number 32 times,
     * counting the number of times you right-shift a one bit off.
     */
    int countOneBits1(int number) {
        int counter = 0;
        int current = number;
        for (int idx = 0; idx < 32; idx++) {
            if (current == 0) {
                break;
            }
            counter += current & 1; //When AND'ing the two values will produce bx00000001, the counter will increment
            current >>= 1;          //Right shift will cause '00010101' to become '00001010'
        }
        return counter;
    }

    /**
     * A similar alternative checks each bit of the number from right to left.
     */
    int countOneBits2(int number) {
        int counter = 0;
        int mask = 1;
        for (int idx = 0; idx < 32; idx++) {
            // Note the importance of the parentheses in the if condition:
            // If they were omitted, then the compiler would interpret the expression as "num & (mask != 0)",
            // since the operator hierarchy places "!=" above "&"
            if ((number & mask) != 0) {
                counter++;
            }
            mask <<= 1;
        }
        return counter;
    }

    /**
     * When you subtract a number by 1, all of the lowest bits change up to and including the lowest 1 bit; but the
     * rest of the bits stay the same. So if I do a bitwise AND of N with N − 1, essentially I will remove the last one
     * bit from N.
     * <p>
     * Once we observe this, we have only to write code that counts how many times we can remove the final bit in
     * this way before we reach a number with no 1 bits at all (i.e., 0).
     */
    int countOneBits3(int num) {
        int counter = 0;
        int current = num;
        while (current != 0) {
            current &= current - 1;  // or current = current & current - 1;
            counter++;
        }
        return counter;
    }

    /**
     * Given a non negative integer number num.
     * <p>
     * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
     * and return them as an array. Example:
     * <p>
     * For num = 5 you should return [0,1,1,2,1,2].
     * <p>
     * 00000000  == 0
     * 00000001  == 1
     * 00000010  == 2
     * 00000011  == 3
     * 00000100  == 4
     * 00000101  == 5
     * 00000110  == 6
     * 00000111  == 7
     * 00001000  == 8
     * 00001001  == 9
     * 00001010  == 10
     * 00001011  == 11
     * 00001100  == 12
     * 00001101  == 13
     * <p>
     * This is an example of dynamic programming where whatever was produced earlier is used. Running time is O(n)
     */
    int[] countOneBits4(final int num) {
        final int[] result = new int[num + 1];
        result[0] = 0;
        for (int idx = 1; idx <= num; idx++) {
            int andResult = idx & (idx - 1);
            result[idx] = result[andResult] + 1;
        }

        return result;
    }

    //There are more efficient ways to count the 1s, but not very straight-forwards during an interview, although impressive!
    //1. http://www.toves.org/books/bitops/ (3.3. A cleverer technique)
    //2. https://yesteapea.wordpress.com/2013/03/03/counting-the-number-of-set-bits-in-an-integer/
    //for 64 bit numbers
    /*
    int NumberOfSetBits64(long i)
    {
        i = i - ((i >> 1) & 0x5555555555555555);
        i = (i & 0x3333333333333333) +
                ((i >> 2) & 0x3333333333333333);
        i = ((i + (i >> 4)) & 0x0F0F0F0F0F0F0F0F);
        return (i*(0x0101010101010101))>>56;
    }
    */
    //for 32 bit integers
    int numberOfSetBits32(int i) {
        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i + (i >> 4)) & 0x0F0F0F0F);
        return (i * (0x01010101)) >> 24;
    }
}
