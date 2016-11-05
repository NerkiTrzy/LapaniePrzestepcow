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
        Path file = Paths.get("src\\Data\\LadowanieDanych.txt");
        
        Files.delete(file);
        Files.createFile(file);
        
        listOfGenerators = new ArrayList<>();
        listOfGenerators.add(new SkinColorGenerator(file));
        listOfGenerators.add(new DistrictGenerator(file));
        listOfGenerators.add(new RatingGenerator(file));
        listOfGenerators.add(new CrimeTypeGenerator(file));
        listOfGenerators.add(new PlaceGenerator(file));
    }
    
    void doYourJob() {        
        for(Generator g : listOfGenerators){
            g.createData();
        }
    }
    
}
