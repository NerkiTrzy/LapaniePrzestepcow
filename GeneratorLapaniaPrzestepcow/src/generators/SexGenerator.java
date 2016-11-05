/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.nio.file.Path;

/**
 *
 * @author Przemysław
 */
public class SexGenerator implements Generator{

    private SQLInsert insert;
    
    private DataLoader dataLoader;

    public SexGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }
    
    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Plec");
        dataLoader.writeDataToFile(insert.createInsertQuery("Plec", "Nazwa", "Mężczyzna"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Plec", "Nazwa", "Kobieta"));
        dataLoader.writeDataToFile("go");    }
    
}