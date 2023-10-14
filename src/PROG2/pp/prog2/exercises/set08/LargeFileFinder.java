package pp.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Paulina Pyczot
 * @date 08.05.2023
 **/

// Aufgabe 4:
public class LargeFileFinder {
    public static void main(String[] args) throws IOException {
        MyFileProcessor fileProcessor = new MyFileProcessor();
        FlexibleFileTreeWalker largeFileFinder = new FlexibleFileTreeWalker(fileProcessor);
        largeFileFinder.walk(".");
        fileProcessor.sortAndPrint();

    }
    private static class MyFileProcessor implements FlexibleFileTreeWalker.FileProcessor {
        private List<File> files = new ArrayList<>();
        @Override
        public void process(File file) throws IOException {
            files.add(file);
        }
        public void sortAndPrint() throws IOException {
            files.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {return -Long.compare(o1.length(),o2.length());
                }
            });
            for (File file : files){
                System.out.printf("%-100s%6d%n", file.getCanonicalPath(),
                        file.length());
            }
        }
    }
}
