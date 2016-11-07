/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EventGenerator implements Generator{
    
    private SQLInsert insert;
    DataLoader dataLoader;
    
    private static final String DELIMITER = "|";
    
    private static final int EVENT_COUNT = 1000000;
    private static final int EVENT_COUNT2 = 250000;
    private Random generator;
    
    public EventGenerator(Path file)
    {
        insert = new SQLInsert();
        //dataLoader = new DataLoader(file);
        generator = new Random();
    }

    @Override
    public void createData() {
        
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter("src\\Data\\event.bulk");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int personCount = getPersonCount();
            int placeCount = getPlaceCount();
            int criminalCount = getCriminalCount();
            for(int i = 0; i < EVENT_COUNT; i++) {

                String id = String.valueOf(i+1);
                String policeman = String.valueOf(generator.nextInt(50) + 1); //= getNotCriminalKey(personCount); // first 50 persons in table are policemen
                String placeId = String.valueOf(generator.nextInt(placeCount)+1);
                String rate = String.valueOf(generator.nextInt(3)+1);
                String criminal = String.valueOf(generator.nextInt(criminalCount)+1);
                String crimeType = String.valueOf(generator.nextInt(7)+1);
                
                bufferedWriter.write(id + DELIMITER +
                        id + DELIMITER +
                        policeman + DELIMITER +
                        placeId + DELIMITER + 
                        rate + DELIMITER +
                        criminal + DELIMITER +
                        crimeType + "\n");
            }
            bufferedWriter.close();
        
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createData2();
    }
    
    public void createData2() {
        
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter("src\\Data\\event2.bulk");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int personCount = getPersonCount();
            int placeCount = getPlaceCount();
            int criminalCount = getCriminalCount();
            for(int i = 2 * EVENT_COUNT; i < 2*EVENT_COUNT + EVENT_COUNT2; i++) {

                String id = String.valueOf(i+1);
                String policeman = String.valueOf(generator.nextInt(50) + 1); //= getNotCriminalKey(personCount); // first 50 persons in table are policemen
                String placeId = String.valueOf(generator.nextInt(placeCount)+1);
                String rate = String.valueOf(generator.nextInt(3)+1);
                String criminal = String.valueOf(generator.nextInt(criminalCount)+1);
                String crimeType = String.valueOf(generator.nextInt(7)+1);
                
                bufferedWriter.write(id + DELIMITER +
                        id + DELIMITER +
                        policeman + DELIMITER +
                        placeId + DELIMITER + 
                        rate + DELIMITER +
                        criminal + DELIMITER +
                        crimeType + "\n");
            }
            bufferedWriter.close();
        
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
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
        return lines - 3;
    }
    
    private int getCriminalCount() {
        BufferedReader reader;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader("src\\Data\\criminal.bulk"));

            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(CriminalGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
    
    private int getPlaceCount() {
        BufferedReader reader;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader("src\\Data\\place.bulk"));

            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(CriminalGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines - 3;
    }
    
    private String getNotCriminalKey(int personCount) {
        int fk_reportingPerson = generator.nextInt(personCount) + 1;
            if(fk_reportingPerson % 10 == 0) // criminals dont get along with Mighty Police
                fk_reportingPerson += generator.nextInt(9) + 1;
            String reportingPerson = String.valueOf(fk_reportingPerson);
        return reportingPerson;
    }
}
