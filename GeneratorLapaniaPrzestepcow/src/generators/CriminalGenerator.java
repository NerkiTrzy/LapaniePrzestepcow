/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CriminalGenerator implements Generator{

    private SQLInsert insert;
    DataLoader dataLoader;
    private Random generator;
    
    private static final int SKIN_COLORS_COUNT = 3;
    private static final String DELIMITER = "|";
    
    public CriminalGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
        generator = new Random();
    }

    
    @Override
    public void createData() {
        int personCount = getPersonCount();
        int count = 0;
        int i = 1;
        while(count < personCount) {
            String id = String.valueOf(i);
            String fk_person = String.valueOf(count);
            String fk_skinColor = String.valueOf(generator.nextInt(SKIN_COLORS_COUNT)+1);
            String previousConflicted = String.valueOf(generator.nextInt(2));
            
            dataLoader.writeDataToFile(id + DELIMITER +
                    fk_person + DELIMITER +
                    fk_skinColor + DELIMITER +
                    previousConflicted);
            count += 10;
            
            i++;
        }
    }
    
    private int getPersonCount() {
        BufferedReader reader;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader("src\\Data\\personInsert.sql"));

            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(CriminalGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
}
