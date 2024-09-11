package app.utils.IO.interfaces;

import java.util.List;

public interface Writer {
	/**
	 * Writes all lines from the given list of strings to the file given by path.
	 * Lines are considered to be terminated by any one of a line feed ('\n').
	 * Rewrites the output file.
	 **/
	void writeLines(List<String> lines);
}
