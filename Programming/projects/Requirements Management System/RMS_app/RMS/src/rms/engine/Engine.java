package rms.engine;

import rms.io.input.ConsoleInput;
import rms.io.input.Input;
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
    private Input input = ConsoleInput.getInputInstance();
    
    private Engine(){
        this.crntMenu = initMenu();
    }
    
    public static Engine getInstance(){
        return engineInstance;
    }
    
    public void run(){
       StringBuilder sbInput = new StringBuilder();
       boolean isExit = false;
       boolean isValidInput = false;
       // show wellcome screen
       output.showOutput(userMessages.getWellcomeMessage());
        // show menu
       this.crntMenu.show(output);
       
         // while not exit
            // get input
            // process input
      
       while(!isExit){
           sbInput.append(input.getInput());
           
           do{
               isValidInput = false;
               for (int key :  this.crntMenu.getMenuItems().keySet()){
                   if((sbInput.toString()).equals(key + "")){
                       isValidInput = true;
                   }
               }
           }while(isValidInput);
           
           output.showOutput(sbInput.toString());
           sbInput.replace(0, sbInput.length(), "");
       }
       
        
        
        // show exit screen
        output.showOutput(userMessages.getGoodbyeMessage());
        
    }
    
    private static Menu initMenu(){
        return new MainMenu();
    }
    
}
