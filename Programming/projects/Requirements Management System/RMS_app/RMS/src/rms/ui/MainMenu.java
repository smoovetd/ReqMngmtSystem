package rms.ui;

import java.util.HashMap;
import rms.io.output.Output;

/**
 *
 * @author blagiev
 */
public class MainMenu implements Menu{
    
    private HashMap<Integer, String> menuItems;
    private Output output;
    
    public MainMenu(Output output){
        this.menuItems = new HashMap();
        this.output = output;
    }
    
    @Override
    public void show(){
        for (int key : this.menuItems.keySet()){
            output.showOutput( key + ": " + this.menuItems.get(key));
        }
    }
    
    protected void initMenu(){
        this.menuItems.put(1,"Open Project");
        this.menuItems.put(2, "New Project");
        this.menuItems.put(3, "Exit");
    }
}
