package rms.entities.project;

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
    
}
