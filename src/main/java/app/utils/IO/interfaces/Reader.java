package app.utils.IO.interfaces;

import java.util.List;

public interface Reader {
	/**
	 * Reads all lines from the file. Lines are considered to be terminated by
	 * any one of a line feed ('\n'), a carriage return ('\r'), a carriage return
	 * followed immediately by a line feed, or by reaching the end-of-file (EOF).
	 *
	 * @return a list with lines from file.
	 */
	List<String> readLines();
}
