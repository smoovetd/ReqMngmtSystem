package rms.ui;

import java.util.HashMap;
import rms.entities.dbLink.DBConnection;
import rms.entities.dbLink.DBConnectionImpl;
import rms.entities.project.Project;
import rms.io.input.Input;
import rms.io.output.Output;

/**
 * This menu appears when Project is selected. Gives all sub-items like Baseline, Requirement and Change Requests
 * @author blagiev
 */
public class EditProjectMenu implements Menu{
    
    private Project project;
    private DBConnection dbConnection;
    
    public EditProjectMenu(Project project) {
        this.setProject(project);
    }

    @Override
    public void setDBConnection(DBConnection dBConnection){
        
    }
    
    @Override
    public DBConnection getDBConnection(){
        return this.dbConnection;
    }
    
    
    private void setProject(Project project){
        this.project = project;
    }
    
    public Project getProject(){
        return this.project;
    }

    @Override
    public void show(Output output) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, String> getMenuItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Menu processCommand(int commandId, Output output, Input input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
