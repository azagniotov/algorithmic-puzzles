package com.zagniotov.puzzles.strings;


import static com.zagniotov.puzzles.common.Utils.swapAll;

class ReverseStringCharactersTake1 {

    ReverseStringCharactersTake1() {

    }

    String reverse(final String subject) {

        if (subject == null || subject.trim().equals("")) {
            return "";
        }

        final char[] chars = subject.toCharArray();
        swapAll(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }
}
