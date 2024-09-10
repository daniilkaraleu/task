package app;

import java.util.Comparator;
import java.util.List;

public class LinesComparator implements Comparator<List<String>> {
    /**
     * Compares its two arguments for order. Returns a negative integer, zero, or a positive
     * integer as the first argument is less than, equal to, or greater than the second.
     *
     * @param o1 – the first object to be compared. o2 – the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     * @throws NullPointerException – if an argument is null and this comparator does not permit null arguments
     * @throws ClassCastException   – if the arguments' types prevent them from being compared by this comparator.
     * @see Comparator
     */
    @Override
    public int compare(List<String> o1, List<String> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int difference;
            String s1 = o1.get(i);
            String s2 = o2.get(i);

            if (isNumeric(s1) && isNumeric(s2))
                difference = Double.compare(Double.parseDouble(s1), Double.parseDouble(s2));
            else if (isNumeric(s1) && !isNumeric(s2)) difference = -1;
            else if (!isNumeric(s1) && isNumeric(s2)) difference = 1;
            else difference = s1.compareTo(s2);

            if (difference == 0)
                continue;
            return difference;
        }

        return Integer.compare(o1.size(), o2.size());
    }

    /**
     * Checks if the given string is a number or not.
     *
     * @param str – string assumed as number.
     * @return true if the string is a number, otherwise false.
     **/
    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex1) {
            return false;
        }
    }
}
