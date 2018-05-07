package rms.ui;

import java.util.HashMap;
import rms.entities.project.Project;
import rms.io.input.Input;
import rms.io.output.Output;
import static rms.utils.IdTracker.LAST_USED_PROJECT_INDEX;

/**
 * Main menu will be displayed on start of the application
 * @author blagiev
 */
public class MainMenu implements Menu{
    
    private HashMap<Integer, String> menuItems;
    
    private Output output;
    
    public MainMenu(){
        this.menuItems = new HashMap();
        initMenu();
    }
    
    @Override
    public void show(Output output){
        for (int key : this.menuItems.keySet()){
            output.showOutput(key + ": " + this.menuItems.get(key));
        }
    }
    
    @Override
    public HashMap<Integer, String> getMenuItems(){
        return this.menuItems;
    }
    
    protected void initMenu(){
        this.menuItems.put(1, "Open Project");
        this.menuItems.put(2, "New Project");
        this.menuItems.put(3, "Exit");
    }
    
    public Project createNewProject(Output output, Input input){
        String name = "";
        String description = "";
        Long id = LAST_USED_PROJECT_INDEX++;
        boolean isInputValid = false;
        
        output.showOutput("Press Esc to return. No project will be set!");
        
        do{
            
            output.showOutput("Enter Project Name:");
            name = input.getInput();
            if(name.length() == 0){
                isInputValid = false;
                output.showOutput("Incorrect Input. Name should not be empty!");
                continue;
            }
        }while(isInputValid);
       
        do{
            output.showOutput("Enter Project Description:");
            description = input.getInput();
            
            if(description.length() == 0){
                isInputValid = false;
                output.showOutput("Incorrect Input. Description should not be empty!");
            } else{
                isInputValid = true;
            }
           
        }while (isInputValid);
        
        Project newProject = new Project(name, description);
        return newProject;
    }
    
}
