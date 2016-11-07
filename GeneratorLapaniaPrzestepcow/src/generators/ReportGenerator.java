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
public class ReportGenerator implements Generator{
    
    private SQLInsert insert;
    DataLoader dataLoader;
    private Random generator;
    
    private static final int REPORT_COUNT = 2000000;
    private static final int REPORT_COUNT_2 = REPORT_COUNT + 500000;
    private static final String DELIMITER = "|";

    public ReportGenerator(Path file)
    {
        insert = new SQLInsert();
        //dataLoader = new DataLoader(file);
        generator = new Random();
    }
    
    @Override
    public void createData() {
        
        try {
            FileWriter fileWriter = new FileWriter("src\\Data\\report.bulk");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        
            int personCount = getPersonCount();
            for(int i = 0; i < REPORT_COUNT; ++i) {
                String id = String.valueOf(i+1);

                int year = generator.nextInt(16) + 2000;
                int month = generator.nextInt(12) + 1;
                int day = generator.nextInt(27) + 1;

                String date = getDateString(year, month, day);

                int fk_reportingPerson = generator.nextInt(personCount-50) + 51; //first 50 people will be policemans
                if(fk_reportingPerson % 10 == 0) // criminals dont get along with Mighty Police
                    fk_reportingPerson += generator.nextInt(9) + 1;
                String reportingPerson = String.valueOf(fk_reportingPerson);        

                bufferedWriter.write(id + DELIMITER +
                        date + DELIMITER +
                        reportingPerson + "\n");
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createData2();
        
    }
    
    public void createData2(){
        try {
            FileWriter fileWriter = new FileWriter("src\\Data\\report2.bulk");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        
            int personCount = getPersonCount();
            for(int i = REPORT_COUNT; i < REPORT_COUNT_2; ++i) {
                String id = String.valueOf(i+1);

                int year = 2016;
                int month = generator.nextInt(11) + 1;
                int day = generator.nextInt(27) + 1;

                String date = getDateString(year, month, day);

                int fk_reportingPerson = generator.nextInt(personCount-50) + 51; //first 50 people will be policemans
                if(fk_reportingPerson % 10 == 0) // criminals dont get along with Mighty Police
                    fk_reportingPerson += generator.nextInt(9) + 1;
                String reportingPerson = String.valueOf(fk_reportingPerson);        

                bufferedWriter.write(id + DELIMITER +
                        date + DELIMITER +
                        reportingPerson + "\n");
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
        return lines;
    }
    
    private String getDateString(int year, int month, int day) {
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(year))
                .append("-")
                .append(String.valueOf(month))
                .append("-")
                .append(String.valueOf(day));
        return result.toString();        
    }
}
