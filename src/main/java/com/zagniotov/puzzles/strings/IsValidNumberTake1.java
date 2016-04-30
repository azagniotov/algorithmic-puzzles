package com.zagniotov.puzzles.strings;


/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * ".1" => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * "-3" => true
 * <p>
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * @see "com.zagniotov.puzzles.strings.IsValidNumberTake1Test"
 */
class IsValidNumberTake1 {

    IsValidNumberTake1() {

    }

    boolean isNumber(String subject) {
        if (subject == null || subject.trim().equals("")) {
            return false;
        }

        subject = subject.trim();
        int start = 0;
        if ("-+".indexOf(subject.charAt(start)) != -1 && subject.length() > 1) {
            start = 1;
        }

        boolean period = false;
        boolean e = false;
        boolean isNumeric = false;
        char[] chars = subject.toCharArray();
        for (int idx = start; idx < chars.length; idx++) {
            if (subject.charAt(idx) == '.') {
                if (period || e) {
                    return false;
                }
                period = true;
                continue;
            }

            if (subject.charAt(idx) == 'e') {
                if (idx == chars.length - 1 || e || idx == 0 || (!isNumeric && ("0123456789".indexOf(subject.charAt(idx - 1)) == -1))) {
                    return false;
                }
                e = true;
                continue;
            }

            if (subject.charAt(idx) == '+') {
                if (idx == chars.length - 1 || (e && subject.charAt(idx - 1) != 'e')) {
                    return false;
                }
                continue;
            }

            if ("0123456789".indexOf(subject.charAt(idx)) == -1) {
                return false;
            } else {
                isNumeric = true;
            }
        }
        return isNumeric;
    }
}
