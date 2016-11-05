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
public class CrimeTypeGenerator implements Generator{

    
    private SQLInsert insert;
    DataLoader dataLoader;

    public CrimeTypeGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }
    
    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Rodzaj_Przestepstwa");
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Kradzież'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Zabójstwo'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Narkotyki'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Pobicie'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Alkohol w miejscu publicznym'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Sprzedaż chipsów w podstawówce'"));
        dataLoader.writeDataToFile(insert.createInsertQuery("Rodzaj_Przestepstwa", "Rodzaj", "'Inne'"));
        dataLoader.writeDataToFile("go");    
    }    
}
