package pp.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;

/**
 * @author Paulina Pyczot
 * @date 08.05.2023
 **/

// Aufgabe 5:
public class DuplicateFileFinder {
    public static void main(String[] args) throws IOException {
        DuplicateFileFinder.MyFileProcessor fileProcessor = new MyFileProcessor();
        FlexibleFileTreeWalker duplicateFileFinder = new FlexibleFileTreeWalker(fileProcessor);
        duplicateFileFinder.walk(".");
        fileProcessor.sortAndPrint();
    }
    private static class MyFileProcessor implements FlexibleFileTreeWalker.FileProcessor {

        @Override
        public void process(File file) throws IOException {

        }
        public void sortAndPrint() throws IOException {

        }
    }
}
