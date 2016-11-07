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
