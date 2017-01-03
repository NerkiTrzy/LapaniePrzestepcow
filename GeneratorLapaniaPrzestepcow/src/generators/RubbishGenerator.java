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
public class RubbishGenerator implements Generator{
    
    private SQLInsert insert;
    private static final String DELIMITER = "|";
    private DataLoader dataLoader;

    public RubbishGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
    }

    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Kolor_Skory");
        
        ArrayList<String> carList = new ArrayList<>();
        ArrayList<String> weatherList = new ArrayList<>();
        ArrayList<String> crimeKindList = new ArrayList<>();
        
        crimeKindList.addAll(Arrays.asList("Kradzież", "Zabójstwo", "Narkotyki", "Pobicie", "Alkohol w miejscu publicznym", "Sprzedaż chipsów w podstawówce", "Inne"));
        carList.addAll(Arrays.asList("BMW 3 Touring", "Volkswagen Sharan", "Volkswagen Golf III", "Volkswagen T5", "Kia Ceed", "BMW 5 Touring", "Volkswagen Caddy"));
        weatherList.addAll(Arrays.asList("Deszcz","Pogodnie","Snieg"));

        for (String crime : crimeKindList){
            for (String car : carList){
                for (String weather : weatherList){
                    dataLoader.writeDataToFile(insert.createInsertQuery("Odpady", 
                            Arrays.asList("WarunkiPogodowe","ModelSamochodu","RodzajPrzestepstwa"),
                            Arrays.asList("'" + weather + "'","'" + car + "'","'" + crime + "'")));
                }
            }   
        }
        dataLoader.writeDataToFile("go");
    }
}
