package rms.ui;

import java.util.HashMap;
import rms.entities.project.Project;
import rms.io.input.Input;
import rms.io.output.Output;

/**
 *
 * @author blagiev
 */
public class EditProjectMenu implements Menu{
    
    private Project project;
    
    public EditProjectMenu(Project project) {
        
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
