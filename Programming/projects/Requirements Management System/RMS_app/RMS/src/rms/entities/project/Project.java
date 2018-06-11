package rms.entities.project;

import static rms.engine.SystemMessages.ERROR_IN_TABLE_CREATION;
import rms.entities.dbLink.DBConnection;
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
    
    private final String projectTableName = "projects";
    
    private DBConnection dbConnection;
    
    //private HashSet<Requirement> requirements;
    
    //private HashSet<ChangeRequest> changeRequests;
    
    //private HashSet<Baseline> baselines;
    
    public Project (String name, String description, DBConnection dbConnection){
        this.setId();
        this.setName(name);
        this.setDescription(description);
        this.setDBConnection(dbConnection);
    }
    
    private void setDBConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }
    
    public DBConnection getDbConnection(){
        return this.dbConnection; 
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
    
    public boolean addProjectToDB(Output output){
        boolean result = false;
        String query = "CREATE TABLE IF NOT EXISTS `" + projectTableName +  "`" + "," + 
                       "'project_id' SMALLINT NOT NULL," +
                       "'project_name' VARCHAR (200) NOT NULL,"+
                       "'project_description' VARCHAR(1000) NOT NULL;";
        
        // create project table if it does not exists
        result = this.getDbConnection().writeToDB(query);
        if (!result){
            output.showOutput(ERROR_IN_TABLE_CREATION + ": " + projectTableName);
            return result;
        }
        
        query = "INSERT INTO " + projectTableName + "( project_id, project_name, project_description)"
                + "VALUES" + ""
                + "(" + this.getId() + ", " + this.getName() + ", " + this.getDescription() + ");";
        
        result = this.getDbConnection().writeToDB(query);
        return result;
    }
    
    public boolean updateProject(){
        boolean result = false;
        
        
        return result;        
    }
    
    
}
