package rms.entities.dbLink;

/**
 * This interface will hold logic for connection to Database
 * @author blagiev
 */
public interface DBConnection {
    
    public boolean writeToDB(String query);
    
    public String readFromDB(String query);
}
