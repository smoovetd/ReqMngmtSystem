package rms.entities.dbLink;

import java.sql.*;

/**
 * Signleton class implementing DB Connection
 * @author blagiev
 */
public class DBConnectionImpl implements DBConnection{
    
    private DBConnectionImpl dBConnectionInstance = new DBConnectionImpl();
    
    private static final String dbSchema = "req_mngmt_sw";

    private static final String dbAddress = "jdbc:mysql://localhost:3306/" ;
    
    private static final String dbUser = "rms_root";
    
    private static final String dbUserPass = "rms_root_Pass1" ;
    
    private DBConnectionImpl(){
    
    }
    
    private void startDBConnection(){
        
    }
    
    private void initDBSchema  (){
        
    }
    
    
    
    public DBConnectionImpl getInstance(){
        return this.dBConnectionInstance;
    }
    
    @Override
    public boolean writeToDB(String query){
        boolean result = false;
        
        
        return result;
    }
    
    @Override
    public String readFromDB(String query){
        String result = "";
        
        
        return result;
    }    
}
