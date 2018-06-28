package rms.entities.dbLink;

import java.sql.*;
import rms.io.output.Output;

/**
 * Signleton class implementing DB Connection
 * @author blagiev
 */
public class DBConnectionImpl implements DBConnection{
    
    private static DBConnectionImpl dBConnectionInstance = new DBConnectionImpl();
    
    private static final String dbSchema = "req_mngmt_sw";

    private static final String dbAddress = "jdbc:mysql://localhost:3306/" ;
    
    private static final String dbUser = "rms_root";
    
    private static final String dbUserPass = "rms_root_Pass1" ;
    
    private static final String additionalConnectionProperties = "?autoReconnect=true&useSSL=false";
    
    private Output output;
        
    private DBConnectionImpl(){
        //initDBSchema();
    }
    
    @Override
    public void setOutput(Output output){
        this.output = output;
    }
    
    public Output getOutput(){
        return this.output;
    }
    
    private void initDBSchema(){
        String query = "";
        try(Connection connection = DriverManager.getConnection(dbAddress + dbSchema + additionalConnectionProperties, dbUser, dbUserPass)){
            this.getOutput().showOutput("Connecting to the databse... SUCCESSFUL");
            query = "CREATE SCHEMA IF NOT EXISTS " + dbSchema;
            connection.prepareStatement(query);
            connection.commit();
        }catch(SQLException ex){               
            ex.printStackTrace();
        } 
    }
    
    
    public static DBConnectionImpl getInstance(){
        return dBConnectionInstance;
    }
    
    @Override
    public boolean writeToDB(String query){
        boolean result = false;
        try(Connection connection = DriverManager.getConnection(dbAddress + dbSchema + additionalConnectionProperties, dbUser, dbUserPass);
            Statement statement = connection.prepareStatement(query)){
            this.getOutput().showOutput("Connecting to the databse... SUCCESSFUL"); 
            statement.executeUpdate(query);
            result = true;
        }catch(SQLException ex){
            ex.printStackTrace();
            this.getOutput().showOutput("SQL Exception recieved: " + ex.getSQLState());
        } 
        
        return result;
    }
    
    @Override
    public String readFromDB(String query){
        String result = "";
        
        
        return result;
    }    
}
