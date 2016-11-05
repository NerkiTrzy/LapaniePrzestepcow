/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorlapaniaprzestepcow;

import generators.SkinColorGenerator;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Przemysław
 */
public class DataLoader {

    Path file;
    
    public DataLoader(Path file){
        this.file = file;
    }
    
    public void writeDataToFile(String data) {
        List<String> list = new ArrayList<>();
        list.add(data);
        try {
            Files.write(file, list, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(SkinColorGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
