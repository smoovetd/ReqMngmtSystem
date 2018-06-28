package rms.ui;

import java.util.HashMap;
import rms.entities.dbLink.DBConnection;
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
    
    private HashMap<Integer, String> menuItems;
    
    public EditProjectMenu(Project project) {
        this.setProject(project);
        this.initMenu();
    }

    @Override
    public void setDBConnection(DBConnection dBConnection){
        this.dbConnection = dbConnection;
    }
    
    @Override
    public DBConnection getDBConnection(){
        return this.dbConnection;
    }
    
    @Override
    public void initMenu(){
        int nextFreeNum = 1;

        this.menuItems = new HashMap();
        
        this.menuItems.put(nextFreeNum++, MenuConstants.EDIT_PROJECT_NAME);
        this.menuItems.put(nextFreeNum++, MenuConstants.EDIT_PROJECT_DESCRIPTION);
        this.menuItems.put(nextFreeNum++, MenuConstants.SEARCH_REQUIREMENT_ID);
        this.menuItems.put(nextFreeNum++, MenuConstants.SEARCH_REQUIREMENT_TEXT);
        this.menuItems.put(nextFreeNum++, MenuConstants.SEARCH_BASELINE_BY_ID);
        this.menuItems.put(nextFreeNum++, MenuConstants.LIST_ALL_BASELINES); 
        this.menuItems.put(nextFreeNum++, MenuConstants.LIST_ALL_REQUIREMENTS);
        this.menuItems.put(nextFreeNum++, MenuConstants.ADD_NEW_REQUIREMENT);
        this.menuItems.put(nextFreeNum++, MenuConstants.ADD_NEW_BASELINE);
        this.menuItems.put(nextFreeNum++, MenuConstants.BACK);             
    }
    
    
    private void setProject(Project project){
        this.project = project;
    }
    
    public Project getProject(){
        return this.project;
    }

    @Override
    public void show(Output output) {
        output.showOutput("\nProject " + this.getProject().getName() + " is opened\n");
         for (int key : this.getMenuItems().keySet()){
            output.showOutput(key + ": " + this.getMenuItems().get(key));
        }       
    }

    @Override
    public HashMap<Integer, String> getMenuItems() {
        return this.menuItems;
    }

    @Override
    public Menu processCommand(int commandId, Output output, Input input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
