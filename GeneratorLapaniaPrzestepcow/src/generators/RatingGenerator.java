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
public class RatingGenerator implements Generator{

    private SQLInsert insert;
    
    private DataLoader dataLoader;

    public RatingGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }
    
    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Ocena");
        dataLoader.writeDataToFile(insert.createInsertQuery("Ocena", "PoziomZadowolenia", "1"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Ocena", "PoziomZadowolenia", "2"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Ocena", "PoziomZadowolenia", "3"));
        dataLoader.writeDataToFile("go");    }
    
}
