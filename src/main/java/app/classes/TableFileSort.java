package app.classes;

import app.classes.interfaces.FileSort;
import app.comparators.GridLinesComparator;
import app.exceptions.UncheckedFileNotFoundException;
import app.utils.IO.TXTFileReader;
import app.utils.IO.TXTFileWriter;
import app.utils.IO.interfaces.Writer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The class is designed to read data from a source file and sort it writing
 * sorted data to the output file
 */
public class TableFileSort implements FileSort {

	static final String REGEX_PATTERN = "\t";
	private List<List<String>> table;

	/**
	 * Processes data table from file, given by name. Sorts table lines according to given Comparator,
	 * writes sorted table to the file, given by name.
	 *
	 * @param readFromFile an absolute file name giving the base location of the input file
	 * @param writeToFile  an absolute file name giving the base location of the output file
	 * @param comparator   a comparator algorithm for table sorting
	 * @see GridLinesComparator
	 */
	public void sortFileData(String readFromFile, String writeToFile, Comparator<? super List<String>> comparator) {
		table = new ArrayList<>();
		readFromFile(readFromFile);

		table.sort(comparator);

		writeToFile(writeToFile);
	}

	/**
	 * Reads all lines from the file, given by name, puts lines to the list, converts lines into
	 * list of strings.
	 *
	 * @param path an absolute file name giving the base location of the input file
	 * @see TXTFileReader
	 */
	private void readFromFile(String path) {
		try {
			TXTFileReader reader = new TXTFileReader(path);
			List<String> lines = reader.readLines();

			for (String line : lines) {
				table.add(Arrays.stream(line.split(REGEX_PATTERN)).collect(Collectors.toList()));
			}
		} catch (FileNotFoundException e) {
			throw new UncheckedFileNotFoundException(e.getMessage(), e.getCause());
		}
	}

	/**
	 * Puts all lines from the list to the file given by name. Rewrites the file.
	 *
	 * @param path an absolute file name giving the base location of the output file
	 * @see TXTFileWriter
	 */
	private void writeToFile(String path) {
		Writer writer = new TXTFileWriter(path);
		List<String> lines = new ArrayList<>(table.size());

		for (List<String> line : table) {
			lines.add(String.join("\t", line) + "\n");
		}

		writer.writeLines(lines);
	}
}
