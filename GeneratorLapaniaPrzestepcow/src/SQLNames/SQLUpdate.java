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
public class SQLUpdate {
    
    public String createUpdateQuery(String tableName, List<String> params, List<String> values,  List<String> condParams, List<String> condValues){
        String query = "";        
        query += "UPDATE " + tableName + " set ";
        
        for (int i = 0; i < params.size(); i++) {
            query += params.get(i) + " = " + values.get(i) + ", ";
        }
        query = query.substring(0, query.length() - 2);
        
        query += " WHERE ";
        
        for (int i = 0; i < condParams.size(); i++) {
            query += condParams.get(i) + " = " + condValues.get(i) + " AND ";
        }
        query = query.substring(0, query.length() - 5);
     
        query += ";";
        return query;
    }    
}
