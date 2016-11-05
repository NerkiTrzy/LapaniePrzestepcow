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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Przemysław
 */
public class SkinColorGenerator implements Generator{
    
    private SQLInsert insert;
    
    private DataLoader dataLoader;

    public SkinColorGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }
    
    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Kolor_Skory");
        dataLoader.writeDataToFile(insert.createInsertQuery("Kolor_Skory", "Kolor", "'Biały'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Kolor_Skory", "Kolor", "'Czarny'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Kolor_Skory", "Kolor", "'Żólty'"));
        dataLoader.writeDataToFile("go");
    }    
}
