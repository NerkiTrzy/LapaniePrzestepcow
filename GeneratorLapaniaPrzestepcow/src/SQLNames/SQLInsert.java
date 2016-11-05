/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLNames;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Przemysław
 */
public class SQLInsert {
    
    public SQLInsert(){
        
    };
    
    public String createInsertQuery(String tableName, List<String> params, List<String> values){
        String query = "";
        String helpingString = "";
        
        query += "INSERT INTO " + tableName + "(";
        
        for (String param : params) {
            helpingString += "," + param;
        }
        helpingString = helpingString.substring(1);
        
        query += helpingString + ") VALUES(";
        
        helpingString = "";
        for (String value : values) {
            helpingString += "," + value;
        }
        helpingString = helpingString.substring(1);
        
        query += helpingString + ");";
        return query;
    }
    
    public String createInsertQuery(String tableName, String param, String value){
        
        List<String> params = new ArrayList<>(); 
        List<String> values = new ArrayList<>(); 
        params.add(param);
        values.add(value);
        
        return createInsertQuery(tableName,params,values);
    }
}
