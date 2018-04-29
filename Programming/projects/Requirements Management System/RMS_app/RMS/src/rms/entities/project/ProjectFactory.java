package rms.entities.project;

/**
 * Class to create new projects
 * Business Requirement 00001
 * @author blagiev
 */
public class ProjectFactory {
    
    private static ProjectFactory projectFactoryInstance = new ProjectFactory();
    
    private ProjectFactory(){
        
    }
    
    public ProjectFactory initProjectFactory(){
        return this.projectFactoryInstance;
    }
    
    public Project createNewProject(String name, String description){
        Project newProject = new Project(name, description);
        // add check for unique name!
        return newProject;
    }
}
