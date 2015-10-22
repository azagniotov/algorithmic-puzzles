package linguistic_chains.utils;

public final class StringUtils {

    private StringUtils() {

    }

    public static String removeCharAt(final int position, final String original) {
        return original.substring(0, position) + original.substring(position + 1);
    }
}
