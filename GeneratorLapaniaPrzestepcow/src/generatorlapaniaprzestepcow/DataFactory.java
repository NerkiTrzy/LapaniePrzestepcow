/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorlapaniaprzestepcow;

import generators.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Przemysław
 */
class DataFactory {

    public List<Generator> listOfGenerators;
    public DataLoader dataLoader;
    public DataLoader dataLoader2;
    
    public final static String pathToBulk = "C:\\Users\\Przemysław\\Documents\\NetBeansProjects\\LapaniePrzestepcow\\GeneratorLapaniaPrzestepcow\\src\\Data\\";
            
    public DataFactory() throws IOException{
        Path file = Paths.get("src\\Data\\LadowanieDanych.sql");
        Path file2 = Paths.get("src\\Data\\LadowanieDanych2.sql");
        
        Files.delete(file);
        Files.createFile(file);
        
        Path personFile = getFile("src\\Data\\person.bulk");
        
        Path criminalFile = getFile("src\\Data\\criminal.bulk");
        
        Path reportFile = getFile("src\\Data\\report.bulk");
        Path placeFile = getFile("src\\Data\\place.sql");
        Path eventFile = getFile("src\\Data\\event.bulk");
        
        listOfGenerators = new ArrayList<>();
        listOfGenerators.add(new SexGenerator(file));
        listOfGenerators.add(new RatingGenerator(file));
        listOfGenerators.add(new CrimeTypeGenerator(file));
        listOfGenerators.add(new DistrictGenerator(file));
        listOfGenerators.add(new CrimeTypeGenerator(file));
        listOfGenerators.add(new SkinColorGenerator(file));
        
        listOfGenerators.add(new PlaceGenerator(placeFile));
        listOfGenerators.add(new PersonGenerator(personFile));
        
        listOfGenerators.add(new CriminalGenerator(criminalFile));
        listOfGenerators.add(new ReportGenerator(reportFile));
        
        listOfGenerators.add(new EventGenerator(eventFile));
        
        listOfGenerators.add(new PolicemenExcelGenerator(null));
        listOfGenerators.add(new InterventionExcelGenerator(null));
        
        dataLoader = new DataLoader(file);
        dataLoader.writeDataToFile("USE LapaniePrzestepcow\nGO");
        
        dataLoader2 = new DataLoader(file2);
        dataLoader2.writeDataToFile("USE LapaniePrzestepcow\nGO");
    }
    
    void doYourJob() {        
        for(Generator g : listOfGenerators){
            g.createData();
        }
        
        String bulksInserts =   "BULK INSERT dbo.Osoba FROM '" + pathToBulk  + "person.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');\n" +
                                "BULK INSERT dbo.Przestepca FROM '" + pathToBulk  + "criminal.bulk' WITH (FIELDTERMINATOR='|');\n" +
                                "BULK INSERT dbo.Miejsce FROM '" + pathToBulk  + "place.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');\n" +
                                "BULK INSERT dbo.Zgloszenie FROM '" + pathToBulk  + "report.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');\n" +
                                "BULK INSERT dbo.Zlapanie_Przestepcy FROM '" + pathToBulk  + "event.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');";
        
        dataLoader.writeDataToFile(bulksInserts);
        
        String bulksInserts2 =  "BULK INSERT dbo.Zgloszenie FROM '" + pathToBulk  + "report2.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');\n" +
                                "BULK INSERT dbo.Zlapanie_Przestepcy FROM '" + pathToBulk  + "event2.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');";
        
        dataLoader2.writeDataToFile(bulksInserts2);
        
    }
    
    private Path getFile(String path) throws IOException {
        Path file = Paths.get(path);
        if(Files.exists(file)) 
            Files.delete(file);
        Files.createFile(file);
        return file;
    }
    
}
