package app;

import app.LinesComparator;
import app.FileSort;
public class Main {
    public static void main(String [] args) {
        final String IN_TXT_PATH = "D:\\SortTask\\target\\in.txt";
        final String OUT_TXT_PATH = "D:\\SortTask\\target\\out.txt";
        FileSort fileSort = new FileSort();

        fileSort.sortFileData(IN_TXT_PATH, OUT_TXT_PATH, new LinesComparator());
    }
}
