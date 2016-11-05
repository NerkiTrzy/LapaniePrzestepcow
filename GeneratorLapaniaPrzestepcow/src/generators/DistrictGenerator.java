/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Przemysław
 */
public class DistrictGenerator implements Generator{

    private SQLInsert insert;
    DataLoader dataLoader;

    public DistrictGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }
    
    @Override
    public void createData() {
       
        dataLoader.writeDataToFile("--TABLE : Dzielnica");
        try {
            Iterator<String> iterator = Files.lines(Paths.get("src\\Data\\Dzielnice.txt")).iterator();
            while(iterator.hasNext())
            {
                dataLoader.writeDataToFile(insert.createInsertQuery("Dzielnica", "Nazwa", ("'" + iterator.next().split(" ")[1]) + "'"));
            }
        } catch (IOException ex) {
            Logger.getLogger(DistrictGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }   
        dataLoader.writeDataToFile("go");
    }    
}
