/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import SQLNames.SQLInsert;
import generatorlapaniaprzestepcow.DataLoader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Przemysław
 */
public class PersonGenerator implements Generator{
    
    private SQLInsert insert;
    
    private DataLoader dataLoader;
    
    private Random generator;

    public PersonGenerator(Path file)
    {
        insert = new SQLInsert();
        dataLoader = new DataLoader(file);
        generator = new Random();
    }

    @Override
    public void createData() {
        dataLoader.writeDataToFile("--TABLE : Osoba");
        
        String itr = "";
        List<String> params = new ArrayList<>();
        
        params.addAll(Arrays.asList("Pesel","Imie","Nazwisko","FK_Plec"));
        
        List<String> values = new ArrayList<>();
        
        List<String> men = new ArrayList<>();
        List<String> women = new ArrayList<>();

        try {
            men = Files.readAllLines(Paths.get("src\\Data\\male_names.txt"),Charset.defaultCharset());
            women = Files.readAllLines(Paths.get("src\\Data\\female_names.txt"),Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(PersonGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int i = 0;
            Iterator<String> iterator = Files.lines(Paths.get("src\\Data\\Nazwiska.txt")).iterator();
            while(iterator.hasNext())
            {
                
                itr = iterator.next();
                values.clear();
                values.add(generatePesel(i+1,true));
                values.add(men.get(i%men.size()));
                values.add(itr);
                values.add("1");                
     
                dataLoader.writeDataToFile(insert.createInsertQuery("Osoba", params, values));
                
                values.clear();
                values.add(generatePesel(i+1,false));
                values.add(women.get(i%women.size()));
                values.add(itr);
                values.add("2");                
     
                dataLoader.writeDataToFile(insert.createInsertQuery("Osoba", params, values));
                  
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(DistrictGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        dataLoader.writeDataToFile("go");    
    }
    
    private String generatePesel(int index, boolean man){
        
        
        String indexString = "000";
        String pesel = "";
        
        pesel += String.valueOf(generator.nextInt(75) + 23);
        
        int months = generator.nextInt(11) + 1;
        if (months < 10) {
            pesel += "0" + String.valueOf(months);    
        }
        else{
            pesel +=  String.valueOf(months);   
        }
        
        int days = generator.nextInt(27) + 1;
        if (days < 10) {
            pesel += "0" + String.valueOf(days);    
        }
        else{
            pesel +=  String.valueOf(days);   
        }
        
        
        indexString = indexString.substring(String.valueOf(index%100).length(), 3);
        pesel += indexString + String.valueOf(index%100);
        
        int sexNumber = (generator.nextInt(1000) * 2)%10;
        if (man) {
            pesel += String.valueOf(sexNumber);
        }
        else{
            pesel += String.valueOf(sexNumber + 1);    
        }
        
        //1×a + 3×b + 7×c + 9×d + 1×e + 3×f + 7×g + 9×h + 1×i + 3×j
        pesel += String.valueOf((10 - (
                Integer.valueOf(pesel.substring(0,1)) * 1 +
                        Integer.valueOf(pesel.substring(0,1)) * 1 +
                        Integer.valueOf(pesel.substring(1,2)) * 3 +
                        Integer.valueOf(pesel.substring(2,3)) * 7 +
                        Integer.valueOf(pesel.substring(3,4)) * 9 +
                        Integer.valueOf(pesel.substring(4,5)) * 1 +
                        Integer.valueOf(pesel.substring(5,6)) * 3 +
                        Integer.valueOf(pesel.substring(6,7)) * 7 +
                        Integer.valueOf(pesel.substring(7,8)) * 9 +
                        Integer.valueOf(pesel.substring(8,9)) * 1 +
                        Integer.valueOf(pesel.substring(9,10)) * 3
                )%10)%10);
        
        return pesel;
    }
    
}
