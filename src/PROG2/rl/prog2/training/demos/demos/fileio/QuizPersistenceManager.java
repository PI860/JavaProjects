package rl.prog2.training.demos.demos.fileio;

import java.io.File;
import java.util.List;

/**
 * General interface used by the {@link QuizGUISwing} to load and save quiz cards.
 * 
 * @author Ruediger Lunde
 */
public interface QuizPersistenceManager {

	String[] getSupportedFileExtensions();
	
	String[] getFileFormatDescriptions();
	
	List<QuizCard> loadCards(File file) throws Exception;

	void saveCards(File file, List<QuizCard> cards) throws Exception;

}
