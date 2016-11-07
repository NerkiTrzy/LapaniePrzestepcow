/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.io.BufferedWriter;
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
public class InterventionExcelGenerator implements Generator{

    private Random generator;
    
    private static final int INTERVENTIONS_COUNT = 500;
    private static final String DELIMITER = ";";
    
    private static final String[] WEATHER = new String[] {
        "Pogodnie",
        "Deszcz",
        "Snieg",
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
    
    private static final String[] CAR_MODELS = new String[] {
        "Volkswagen T5",
        "Volkswagen Golf III",
        "Volkswagen Sharan",
        "Volkswagen Caddy",
        "BMW 3 Touring",
        "BMW 5 Touring",
        "Kia Ceed"
    };

    
    public InterventionExcelGenerator(Path file)
    {
        generator = new Random();
    }
    
    @Override
    public void createData() {
        try {
            FileWriter fileWriter = new FileWriter("src\\Data\\intervention.csv");
        
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
            bufferedWriter.write("Czas trwania interwencji;Model samochodu;Liczba rannych;"
                    + "Liczba zabitych;Najwyzszy stopien;Stan warunkow atmosferycznych;"
                    + "Okres swiateczny" + "\n");
            
            
            
            for(int i = 0; i < INTERVENTIONS_COUNT; ++i) {

                String duration = String.valueOf(generator.nextInt(3600) + 360);
                String carModel = CAR_MODELS[generator.nextInt(CAR_MODELS.length)];
                String injured = String.valueOf(generator.nextInt(5));
                String dead = String.valueOf(generator.nextInt(2));
                String maxRank = RANKS[generator.nextInt(RANKS.length)];
                String weather = WEATHER[generator.nextInt(WEATHER.length)];
                String duringHoliday = String.valueOf(generator.nextInt(2));
                
                bufferedWriter.write(duration + DELIMITER +
                        carModel + DELIMITER +
                        injured + DELIMITER +
                        dead + DELIMITER +
                        maxRank + DELIMITER +
                        weather + DELIMITER +
                        duringHoliday + DELIMITER + "\n");
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(EventGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
