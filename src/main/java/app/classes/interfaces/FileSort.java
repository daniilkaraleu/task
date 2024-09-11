package app.classes.interfaces;

import java.util.Comparator;
import java.util.List;

public interface FileSort {
	void sortFileData(String readFromFile, String writeToFile, Comparator<? super List<String>> comparator);
}
