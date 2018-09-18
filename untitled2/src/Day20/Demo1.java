package Day20;

import java.io.*;

public class Demo1 {
    public static void copyFileChar(File refile,File wrfile) throws IOException {
        FileReader fileReader=new FileReader(refile);
        FileWriter fileWriter=new FileWriter(wrfile);
        int readChar;
        while ((readChar=fileReader.read())!=-1){
            fileWriter.write(readChar);
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void copyFileChars(File refile,File wrfile) throws IOException{
        FileReader fileReader=new FileReader(refile);
        FileWriter fileWriter=new FileWriter(wrfile);
        int len=-1;
        char[] buf=new char[1024];
        while((len = fileReader.read(buf)) != -1) {
            fileWriter.write(buf, 0, len);
        }

        fileReader.close();
        fileWriter.close();
}

    public static void main(String args[]){
        try {
            copyFileChar(new File("a.txt"),new File("copyFileChar.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
