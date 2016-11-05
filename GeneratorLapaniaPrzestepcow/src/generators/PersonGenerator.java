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
public class PersonGenerator implements Generator{
    
    private SQLInsert insert;
    
    private DataLoader dataLoader;

    public PersonGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }

    @Override
    public void createData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
