package rms.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rms.entities.project.Project;
import rms.io.input.Input;
import rms.io.output.Output;
import static rms.utils.IdTracker.LAST_USED_PROJECT_INDEX;

/**
 * Main menu will be displayed on start of the application
 * There will be options to Open new Project, Edit current Project or Exit
 * Command will be processed and passed to Edit Project Menu (new or existing) or Exit
 * @author blagiev
 */
public class MainMenu implements Menu{
    
    private HashMap<Integer, String> menuItems;
    
    private Output output;
    
    private static Menu mainMenuInstance = new MainMenu();
    
    private Set<Project> projects;
    
    private MainMenu(){ 
        this.menuItems = new HashMap();
        initMenu();
        this.projects = new HashSet<Project>();
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
            
            if(name.equals("")){
                isInputValid = false;
                output.showOutput("Incorrect Input. Name should not be empty!");
            } else{
                isInputValid = true;
            }
        }while(!isInputValid);
       
        do{
            output.showOutput("Enter Project Description:");
            description = input.getInput();
            
            if(description.equals("")){
                isInputValid = false;
                output.showOutput("Incorrect Input. Description should not be empty!");
            } else{
                isInputValid = true;
            }
           
        }while (!isInputValid);
        
        Project newProject = new Project(name, description);
        return newProject;
    }
    
    private void addProject(Project project){
        this.projects.add(project);
    }
    
    public Set<Project> getProjects(){
        return this.projects;
    }
    
    public Long selectExistingProjectID(Output output, Input input){
        String crntInput = "";
        boolean isValidInput = false;
        long crntId = -1l;
        
        do{
            output.showOutput("List Of All Projects is: ");
            printProjectsById(output);
            output.showOutput("Enter ID:");
            isValidInput = false;
            crntInput = input.getInput();
            
            try{
                crntId = Long.valueOf(crntInput);
            }catch(NumberFormatException ex){
                output.showOutput("Invalid number is entered!");
                continue;
            }
            
            
        }while(!isValidInput);
        
        return crntId;
    }
    
    @Override
    public Menu processCommand(int commandId, Output output, Input input){
        Menu newMenuItem = null;
        Long crntProjID = -1l;
        Project crntProj = null;
        
        switch (this.menuItems.get(commandId).toUpperCase()){
            case MenuConstants.OPEN_EXISTING_PROJECT:
                crntProjID = selectExistingProjectID(output, input);
                if(crntProjID == null){
                    newMenuItem = null;
                }
                crntProj = getProjectByID(crntProjID);
                break;
                                
            case MenuConstants.OPEN_NEW_PROJECT:
                crntProj = createNewProject(output, input);
                if (crntProj != null){
                    crntProj.printProjInfo(output);
                    crntProjID = crntProj.getId();
                    newMenuItem = new EditProjectMenu(crntProj);
                    throw new RuntimeException("Open existing project menu is not available");
                } else{
                    newMenuItem = getMainMenuInstance();
                }
                break;
            case MenuConstants.EXIT:
                newMenuItem = null;
                break;
            
            default: 
                throw new InternalError("Invalid menu option is provided");
                //break;
        }
        return newMenuItem;
    }
    
    public void printProjectsById(Output output){
        this.projects.stream().forEach(crntProj -> output.showOutput("Project ID: " + crntProj.getId() + " Name: " + crntProj.getName()));
    }
    
    
    public boolean isProjectIDValid(long id){
        boolean result = false;
        
        for(Project crntProj : this.projects){
            if(crntProj.getId() == id){
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public Project getProjectByID(long id){
        Project crntProj = null;
        
        for (Project proj : this.projects){
            if(id == proj.getId()){
                crntProj = proj;
                break;
            }
        }
        
        return crntProj;
    }
}
