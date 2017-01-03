/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PolicemenExcelGenerator implements Generator {

    private Random generator;
    
    private static final int POLICEMEN_COUNT = 50;
    private static final String DELIMITER = ";";
    
    private static final String[] DEPARTMENTS = new String[] {
        "Kryminalny",
        "Prewencyjny",
        "Drogowy",
        "Oddziały specjalne"
        };
    private static final String[] RANKS = new String[] {
        "Posterunkowy",
        "Starszy posterunkowy",
        "Przodownik",
        "Starszy przodownik",
        "Aspirant",
        "Podkomisarz",
        "Komisarz",
        "Nadkomisarz",
        "Podinspektor",
        "Inspektor"
    };

    
    public PolicemenExcelGenerator(Path file)
    {
        generator = new Random();
    }
    
    @Override
    public void createData() {
        try {
            FileWriter fileWriter = new FileWriter("src\\Data\\policemen.csv");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
            bufferedWriter.write("PESEL;Imie;Nazwisko;Wydzial;Stopien;"
                    + "Data rozpoczecia sluzby;Data zakonczenia sluzby;" + "\n");
            Iterator<String> iterator = Files.lines(Paths.get("src\\Data\\person.bulk")).iterator();
            
            
            
            for(int i = 0; i < POLICEMEN_COUNT; ++i) {
                
                String[] policemanData = iterator.next().split("\\|");
                

                int year = generator.nextInt(12) + 2004;
                int month = generator.nextInt(12) + 1;
                int day = generator.nextInt(27) + 1;

                String startDate = getDateString(year, month, day);
                String PESEL = policemanData[1];
                String name = policemanData[2];
                String surname = policemanData[3];
                String department = DEPARTMENTS[generator.nextInt(DEPARTMENTS.length)];
                String rank = RANKS[generator.nextInt(RANKS.length)];;
                String endDate = "";
                bufferedWriter.write(PESEL + DELIMITER +
                        name + DELIMITER +
                        surname + DELIMITER +
                        department + DELIMITER +
                        rank + DELIMITER +
                        startDate + DELIMITER +
                        endDate + DELIMITER + "\n");
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createData2();
    }
    
    
    private void createData2(){
        try {
            FileWriter fileWriter = new FileWriter("src\\Data\\policemen2.csv");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
            bufferedWriter.write("PESEL;Imie;Nazwisko;Wydzial;Stopien;"
                    + "Data rozpoczecia sluzby;Data zakonczenia sluzby;" + "\n");
            Iterator<String> iterator = Files.lines(Paths.get("src\\Data\\policemen.csv")).iterator();
            
            
            
            for(int i = 1; i < POLICEMEN_COUNT + 1; ++i) {
                
                String[] policemanData = iterator.next().split(";");
                
                if (i%4 == 0) { 
                    String startDate = policemanData[5];
                    String PESEL = policemanData[1];
                    String name = policemanData[2];
                    String surname = policemanData[3];
                    int dep = getDepartment(policemanData[4]);
                    if (dep == 3) {
                        dep = 1;
                    }
                    else{
                        dep++;
                    }
                    int rankNumber = getRank(policemanData[5]);
                    if (rankNumber == 9) {
                        rankNumber--;
                    }
                    else{
                        rankNumber++;
                    }
                   
                    String department = DEPARTMENTS[dep];
                    String rank = RANKS[rankNumber];
                    String endDate = "";
                    if (i%10 == 0) {
                        int year = 2016;
                        int month = generator.nextInt(12) + 1;
                        int day = generator.nextInt(27) + 1;
                        endDate = getDateString(year, month, day);
                    }
                    bufferedWriter.write(PESEL + DELIMITER +
                    name + DELIMITER +
                    surname + DELIMITER +
                    department + DELIMITER +
                    rank + DELIMITER +
                    startDate + DELIMITER +
                    endDate + DELIMITER + "\n");
                    
                }

                
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private int getDepartment(String department){
        for (int i = 0; i < 4; i++) {
            if(DEPARTMENTS[i].equals(department)){
                return i;
            }
        }
        return -1;
    }
    
     private int getRank(String department){
        for (int i = 0; i < 10; i++) {
            if(RANKS[i].equals(department)){
                return i;
            }
        }
        return -1;
    }
    
    private String getDateString(int year, int month, int day) {
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(year))
                .append("-");
        if (month < 10) {
            result.append("0" + String.valueOf(month));
                
        }
        else{
            result.append(String.valueOf(month));
        }
        result.append("-");
        if (day < 10) {
            result.append("0" + String.valueOf(day));
        }
        else{
            result.append(String.valueOf(day));
        }   
                
        return result.toString();        
    }
}
