package app.utils.IO;

import app.utils.IO.interfaces.Reader;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class TXTFileReader implements Reader {
	private final String FILE_PATH;

	/**
	 * Constructor with string parameter of the file.txt path considered to be read.
	 *
	 * @param FILE_PATH - readable file path.
	 * @throws FileNotFoundException -if the named file does not exist,
	 *                               is a directory rather than a regular file, or for some other reason cannot be opened for reading.
	 */
	public TXTFileReader(String FILE_PATH) throws FileNotFoundException {
		this.FILE_PATH = FILE_PATH;

		File file = new File(FILE_PATH);
		if (!(file.exists() && file.isFile()))
			throw new FileNotFoundException("File is not found at " + FILE_PATH);
	}

	/**
	 * Reads all lines of text from the txt file given by path from constructor. Lines are
	 * considered to be terminated by any one of a line feed ('\n'),
	 * a carriage return ('\r'), a carriage return followed immediately
	 * by a line feed, or by reaching the end-of-file (EOF).
	 *
	 * @return a list with lines from file.
	 * @throws UncheckedIOException - if any I/O error occurs
	 * @see BufferedReader
	 */
	public List<String> readLines() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
