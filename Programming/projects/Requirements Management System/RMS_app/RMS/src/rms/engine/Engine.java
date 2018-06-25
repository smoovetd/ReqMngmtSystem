package rms.engine;

import rms.entities.dbLink.DBConnection;
import rms.entities.dbLink.DBConnectionImpl;
import rms.io.input.ConsoleInput;
import rms.io.input.Input;
import rms.io.output.ConsoleOutput;
import rms.io.output.Output;
import rms.ui.MainMenu;
import rms.ui.Menu;
import rms.ui.UserMessages;


/**
 * Engine - singleton class that runs the application
 * run() waits for input and input is processed until command for Exit is received.
 * @author blagiev
 */
public class Engine {
   
    private static Engine engineInstance = new Engine();
    private Output output = ConsoleOutput.getInstance();
    private UserMessages userMessages = UserMessages.getInstance();
    private Menu crntMenu;
    private Input input = ConsoleInput.getInputInstance();
    
    private Engine(){
        this.crntMenu = MainMenu.getMainMenuInstance();
    }
    
    public static Engine getInstance(){
        return engineInstance;
    }
    
    public void run(){
       StringBuilder sbInput = new StringBuilder();
       boolean isExit = false;
       boolean isValidInput = false;
       
       DBConnection dBConnection = DBConnectionImpl.getInstance();
       dBConnection.setOutput(output);
       
// show wellcome screen
       output.showOutput(userMessages.getWellcomeMessage());
       
       
       // create DB if not exists
       
       // show menu
       this.crntMenu.show(output);
       
         // while not exit
            // get input
            // process input
       while(!isExit){          
           do{
               sbInput.append(input.getInput());
               isValidInput = false;
               for (int key :  this.crntMenu.getMenuItems().keySet()){
                   if((sbInput.toString()).equals(key + "")){
                       isValidInput = true;
                       break;
                   }
               }
               
               if(!isValidInput){
                   output.showOutput("Incorrect Input was entered!");
                   sbInput.replace(0, sbInput.length(), "");
               }
               
           }while(!isValidInput);
           
           output.showOutput(sbInput.toString());
           
           this.crntMenu.setDBConnection(dBConnection);
           
           this.crntMenu = this.crntMenu.processCommand(Integer.valueOf(sbInput.toString()), output, input);
           if (this.crntMenu == null){
               isExit = true;
           } else{
               this.crntMenu.show(output);
           }
           sbInput.replace(0, sbInput.length(), "");
       }
       
        // show exit screen
        output.showOutput(userMessages.getGoodbyeMessage());
        
    }
    
}
