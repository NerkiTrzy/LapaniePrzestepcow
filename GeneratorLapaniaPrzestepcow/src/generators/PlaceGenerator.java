/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Przemysław
 */
public class PlaceGenerator implements Generator{
    
    private SQLInsert insert;
    private static final String DELIMITER = "|";
    //private DataLoader dataLoader;

    public PlaceGenerator(Path file)
    {
        insert = new SQLInsert();
        //dataLoader = new DataLoader(file);
    }

    @Override
    public void createData() {
         try {
            FileWriter fileWriter = new FileWriter("src\\Data\\place.bulk");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            String itr = "";
            List<String> params = new ArrayList<>();
            params.addAll(Arrays.asList("FK_Dzielnica","Nazwa_Ulicy","Numer"));

            List<String> values = new ArrayList<>();

            //dataLoader.writeDataToFile("--TABLE : Miejsce");

            int id = 0;
            Iterator<String> iterator = Files.lines(Paths.get("src\\Data\\Ulice.txt")).iterator();
            while(iterator.hasNext())
            {
                itr = iterator.next();
//                    values.clear();
//                    values.add(itr.split("!")[0]);
//                    values.add("'" + itr.split("!")[1] + "'");
//                    values.add("0");
                String arg0 = itr.split("!")[0];
                String arg1 = itr.split("!")[1];
                for (int i = 1; i <= 15; i++) {
//                        values.remove(2);
//                        values.add(String.valueOf(i));
                    ++id;
                    bufferedWriter.write(String.valueOf(id) + DELIMITER +
                            arg0 + DELIMITER + 
                            arg1 + DELIMITER +
                            String.valueOf(i) + "\n");
                    //dataLoader.writeDataToFile(insert.createInsertQuery("Miejsce", params, values));
                }   
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(DistrictGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }   

        //dataLoader.writeDataToFile("go");
    }
}
