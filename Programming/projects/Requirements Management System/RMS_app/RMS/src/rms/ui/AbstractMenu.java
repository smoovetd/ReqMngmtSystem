package rms.ui;

import rms.entities.dbLink.DBConnection;

/**
 * This is an abstract menu class. It holds DB connection for all menu items
 *
 * @author blagiev
 */
// For now will not be used due to usage of static Menu methods
/*
public abstract class AbstractMenu implements Menu {
    
    private DBConnection dbconnection;
    
    protected AbstractMenu(DBConnection dbConnection){
        this.setDBConnection(dbConnection);
    }
    
    private void setDBConnection(DBConnection dbConnection){
        this.dbconnection = dbConnection;
    }
    
    @Override
    public DBConnection getDBConnection(){
        return this.dbconnection;
    }
}
*/