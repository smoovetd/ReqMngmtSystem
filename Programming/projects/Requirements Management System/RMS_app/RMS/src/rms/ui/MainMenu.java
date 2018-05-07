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
    
    private static Menu mainMenuInstance = new MainMenu();
    
    private MainMenu(){
        this.menuItems = new HashMap();
        initMenu();
    }
    
    public static Menu getMainMenuInstance(){
        return mainMenuInstance;
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
        this.menuItems.put(1, MenuConstants.OPEN_EXISTING_PROJECT);
        this.menuItems.put(2, MenuConstants.OPEN_NEW_PROJECT);
        this.menuItems.put(3, MenuConstants.EXIT);
    }
    
    public static Project createNewProject(Output output, Input input){
        String name = "";
        String description = "";
        Long id = LAST_USED_PROJECT_INDEX++;
        boolean isInputValid = false;
        
        output.showOutput("Press Back to return. No project will be set!");
        
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
    
    @Override
    public Menu processCommand(int commandId, Output output, Input input){
        Menu newMenuItem = null;
        
        switch (this.menuItems.get(commandId).toUpperCase()){
            case MenuConstants.OPEN_EXISTING_PROJECT:
                throw new RuntimeException("Open existing project menu is not available");
                //break;
            case MenuConstants.OPEN_NEW_PROJECT:
                Project crntProj = createNewProject(output, input);
                if (crntProj != null){
                    crntProj.printProjInfo(output);
                    throw new RuntimeException("Open existing project menu is not available");
                } else{
                    newMenuItem = getMainMenuInstance();
                }
                //break;
            case MenuConstants.EXIT:
                newMenuItem = null;
                break;
            
            default: 
                throw new InternalError("Invalid menu option is provided");
                //break;
        }
        return newMenuItem;
    }
    
}
