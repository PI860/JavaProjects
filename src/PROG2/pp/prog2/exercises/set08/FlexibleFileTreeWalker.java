package pp.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;

/**
 * @author Paulina Pyczot
 * @date 08.05.2023
 **/

// Aufgabe 3:
public class FlexibleFileTreeWalker {
    private FileProcessor fileProcessor;

    public FlexibleFileTreeWalker(FileProcessor fileProcessor){
        this.fileProcessor = fileProcessor;
    }

    public void walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        if (files != null) {
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else
                    fileProcessor.process(file);
        }
    }

    static interface FileProcessor{
        void process(File file) throws IOException;

    }
}
