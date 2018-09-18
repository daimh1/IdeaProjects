package StreamIO;

import javax.swing.*;
import java.io.File;

public class Jfilechoose {
    public static void main(String args[]){
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File f = jFileChooser.getSelectedFile();
        if(f != null){}
    }


}
