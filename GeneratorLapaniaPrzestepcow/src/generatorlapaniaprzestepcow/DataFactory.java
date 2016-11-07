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
    
    public DataFactory() throws IOException{
        Path file = Paths.get("src\\Data\\LadowanieDanych.sql");
        
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
        
    }
    
    void doYourJob() {        
        for(Generator g : listOfGenerators){
            g.createData();
        }
    }
    
    private Path getFile(String path) throws IOException {
        Path file = Paths.get(path);
        if(Files.exists(file)) 
            Files.delete(file);
        Files.createFile(file);
        return file;
    }
    
}
