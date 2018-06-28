package rms.ui;

import java.util.HashMap;
import rms.entities.dbLink.DBConnection;
import rms.io.input.Input;
import rms.io.output.Output;

/**
 * Interface that will hold method display() - for all menu levels
 * @author blagiev
 */
public interface Menu {
    public void show(Output output);
    
    public HashMap<Integer, String> getMenuItems();
    
    public Menu processCommand(int commandId, Output output, Input input);
    
    public DBConnection getDBConnection();
    
    public void setDBConnection(DBConnection dbConnection);
    
    public void initMenu();
}
