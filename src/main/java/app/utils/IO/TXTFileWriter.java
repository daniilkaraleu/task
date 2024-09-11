package app.utils.IO;

import app.utils.IO.interfaces.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class TXTFileWriter implements Writer {
	private final String FILE_PATH;

	public TXTFileWriter(String FILE_PATH) {
		this.FILE_PATH = FILE_PATH;
	}

	/**
	 * Writes all lines of text from the given list of strings to the txt file given by path.
	 * Lines are considered to be terminated by any one of a line feed ('\n').
	 * Rewrites the output file.
	 *
	 * @throws UncheckedIOException - if any I/O error occurs
	 * @see BufferedWriter
	 */
	@Override
	public void writeLines(List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (String line : lines) {
				writer.write(line);
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
