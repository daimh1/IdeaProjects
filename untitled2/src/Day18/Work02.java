package Day18;

import java.io.*;

public class Work02 {
    static File txt=new File("d:\\c.txt");
    public static void main(String args[]){
        File file=new File("D:\\迅雷下载");
        searchAvi(file);

    }
    static void searchAvi(File file){
        File[] files = file.listFiles() ;
        //if(files.length==0){return;}
        //if(file.list().length ==  0){return;}
        for(File f : files)
        {
            if(f==null){continue;}
            if(f.isFile()&&f.getName().endsWith(".avi")){

                BufferedWriter bufferedWriter= null;
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(txt, true)));
                    bufferedWriter.write(f.getName()+"\r\n");
                    bufferedWriter.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /*FileWriter fw = null;
                try {
                    fw = new FileWriter(txt,true);
                    fw.write(f.getName()+"\r\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


                System.out.println(f.getName());
            }else if(f.isDirectory()){
                searchAvi(f);
            }
        }
    }
}
