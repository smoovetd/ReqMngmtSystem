package rms.ui;

import java.util.HashMap;
import rms.io.output.Output;

/**
 *
 * @author blagiev
 */
public class MainMenu implements Menu{
    
    private HashMap<Integer, String> menuItems;
    
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
    
    protected void initMenu(){
        this.menuItems.put(1, "Open Project");
        this.menuItems.put(2, "New Project");
        this.menuItems.put(3, "Exit");
    }
}
