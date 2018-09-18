package IO;

import java.io.FileFilter;
import java.io.File;

public class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return true;
    }
}
