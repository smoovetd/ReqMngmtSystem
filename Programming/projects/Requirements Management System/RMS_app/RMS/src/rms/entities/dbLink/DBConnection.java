package rms.entities.dbLink;

import rms.io.output.Output;

/**
 * This interface will hold logic for connection to Database
 * @author blagiev
 */
public interface DBConnection {
    
    public boolean writeToDB(String query);
    
    public String readFromDB(String query,String[] columns);
    
    public void setOutput(Output output);
}
