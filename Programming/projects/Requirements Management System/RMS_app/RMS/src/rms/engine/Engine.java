package rms.engine;

import rms.io.output.ConsoleOutput;
import rms.io.output.Output;
import rms.ui.MainMenu;
import rms.ui.Menu;
import rms.ui.UserMessages;


/**
 * Engine - singleton class that runs the application
 * @author blagiev
 */
public class Engine {
   
    private static Engine engineInstance = new Engine();
    private Output output = ConsoleOutput.getInstance();
    private UserMessages userMessages = UserMessages.getInstance();
    private Menu crntMenu;
    
    private Engine(){
        this.crntMenu = initMenu();
    }
    
    public static Engine getInstance(){
        return engineInstance;
    }
    
    public void run(){
        // show wellcome screen
       output.showOutput(userMessages.getWellcomeMessage());
        // show menu
       this.crntMenu.show(output);
        // while not exit
            // get input
            // process input
        
        
        // show exit screen
        output.showOutput(userMessages.getGoodbyeMessage());
        
    }
    
    private static Menu initMenu(){
        return new MainMenu();
    }
    
}
