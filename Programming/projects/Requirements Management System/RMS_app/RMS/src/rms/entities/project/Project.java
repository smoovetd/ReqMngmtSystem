package rms.entities.project;

import rms.io.output.Output;
import rms.utils.IdTracker;

/**
 * Projects will be the base object - all requirements and change requests will be related to a projects.
 * Each project can have many requirements and change requests.
 * Projects will be stored in project table.
 * @author blagiev
 */
public class Project {
    
    private long id;
    
    private String name;
    
    private String description;
    
    //private HashSet<Requirement> requirements;
    
    //private HashSet<ChangeRequest> changeRequests;
    
    //private HashSet<Baseline> baselines;
    
    public Project (String name, String description){
        this.setId();
        this.setName(name);
        this.setDescription(description);
    }
    
    private void setId(){
        this.id = IdTracker.LAST_USED_PROJECT_INDEX++;
    }
    
    public long getId(){
        return this.id;
    }
    
    
    private void setName(String name){
        if (name.isEmpty()){
            throw new IllegalArgumentException("name of the project cannot be empty!");
        }
        
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    private void setDescription(String description){
        if (name.isEmpty()){
            throw new IllegalArgumentException("description of the project cannot be empty!");
        }
        
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    /**
     * This method is for debug purposes - prints information for the project
     */
    public void printProjInfo(Output output){
        StringBuilder sb = new StringBuilder();
        sb.append("Project ID: " + this.getId() + "\n");
        sb.append("Project Name: " + this.getName() + "\n");
        sb.append("Project Description: " + this.getDescription());
        output.showOutput(sb.toString());
    }
    
    public boolean addProjectToDB(){
        boolean result = false;
        String query = "";
        
        return result;
    }
    
    public boolean updateProject(){
        boolean result = false;
        
        
        return result;        
    }
    
    
}
