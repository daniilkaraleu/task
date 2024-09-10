package app;
//import java.io.BufferedReader;
//import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**The class is designed to read data from a source file and sort it writing
 * sorted data to the output file
 */
public class FileSort {

    static String REGEX_PATTERN = " +";
    private List<List<String>> table;
    private app.FileReadWrite readWriter;
    /**
     * Processes data table from file, given by name. Sorts table lines according to given Comparator,
     * writes sorted table to the file, given by name.
     *
     * @param  readFromFile an absolute file name giving the base location of the input file
     * @param  writeToFile an absolute file name giving the base location of the output file
     * @param  comparator a comparator algorithm for table sorting
     * @see    LinesComparator
     */
    public void sortFileData(String readFromFile, String writeToFile, Comparator<? super List<String>> comparator) {
        table= new ArrayList<>();
        readWriter = new FileReadWrite();

        readFromFile(readFromFile);

        table.sort(comparator);

        writeToFile(writeToFile);

    }
    /**
     * Reads all lines from the file, given by name, puts lines to the list, converts lines into
     * list of strings.
     *
     * @param  path an absolute file name giving the base location of the input file
     * @see    FileReadWrite
     */
    private void readFromFile(String path) {
        List <String> lines= readWriter.readLines(path);

        for (String line : lines) {
            table.add(Arrays.stream(line.split(REGEX_PATTERN)).collect(Collectors.toList()));
        }
    }
    /**
     * Puts all lines from the list to the file given by name. Rewrites the file.
     *
     * @param  path an absolute file name giving the base location of the output file
     * @see    FileReadWrite
     */
    private void writeToFile(String path) {
        List<String> lines = new ArrayList<>(table.size());

        for (List<String> line : table) {
            lines.add(String.join("\t", line) + "\n");
        }

        readWriter.writeLines(lines, path);
    }
}
