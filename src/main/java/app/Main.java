package app;

import app.classes.TableFileSort;
import app.classes.interfaces.FileSort;
import app.comparators.GridLinesComparator;

public class Main {
    public static void main(String [] args) {
        final String IN_TXT_PATH = "in.txt";
        final String OUT_TXT_PATH = "out.txt";
        FileSort fileSort = new TableFileSort();

        fileSort.sortFileData(IN_TXT_PATH, OUT_TXT_PATH, new GridLinesComparator());
    }
}
