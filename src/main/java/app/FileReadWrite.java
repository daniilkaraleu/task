package app;

import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadWrite {
//    private final Charset charset = StandardCharsets.UTF_8;
public FileReadWrite() {}
    /**
     * Reads all lines of text from the file by given path. Lines are considered to be terminated by
     * any one of a line feed ('\n'), a carriage return ('\r'), a carriage return
     * followed immediately by a line feed, or by reaching the end-of-file (EOF).
     *
     * @param  FILE_PATH an absolute path to read file giving the base location of the input file
     * @return a list with lines from file.
     * @throws UncheckedIOException - if any I/O error occurs
     * @see    BufferedReader
     */
    public List<String> readLines(String FILE_PATH) {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    /**
     * Writes all lines of text from the given list of strings to the file given by path.
     * Lines are considered to be terminated by any one of a line feed ('\n').
     * Rewrites the output file.
     *
     * @param  FILE_PATH an absolute path to written file giving the base location of the output file
     * @throws UncheckedIOException - if any I/O error occurs
     * @see    BufferedWriter
     */
    public void writeLines(List<String> lines, String FILE_PATH) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

//        for (String line : lines) {
//            Path pathToWrite = new File(FILE_PATH).toPath();
//
//            StringBuilder sbd = new StringBuilder(line);
//            sbd.append("\n");
//
//            Files.writeString(pathToWrite, sbd, StandardOpenOption.APPEND);
//        }
    }
}
