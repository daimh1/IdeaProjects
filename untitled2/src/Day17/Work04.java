package Day17;

import java.io.File;

public class Work04 {
    public static void deleteFiles(File file)
    {
        if(file.isFile() || file.list().length ==  0)
        {

            file.delete() ;
        }
        else
        {
            File[] files = file.listFiles() ;
            for(File f : files)
            {
                deleteFiles(f) ;
                f.delete() ;
            }

        }
    }
    public static void deleteAndRetainThis(File file,File absolute)
    {
        if(file.isFile())
        {
            file.delete() ;
        }
        else if(file.list().length ==  0){
            if(file==absolute){
                return;
            }else {
                file.delete();
            }
        }
        else
        {
            File[] files = file.listFiles() ;
            for(File f : files)
            {
                deleteAndRetainThis(f,absolute); ;
                f.delete() ;
            }

        }
    }
    public static void main(String args[]){
        deleteAndRetainThis(new File("D:\\newDocument"),new File("D:\\newDocument"));
    }
}
