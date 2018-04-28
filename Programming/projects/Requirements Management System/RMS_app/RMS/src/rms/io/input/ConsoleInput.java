package rms.io.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import rms.engine.SystemMessages;

/**
 * Console implementation of Input interface
 * @author blagiev
 */
public class ConsoleInput implements Input {
    
    private static ConsoleInput inputInstance = new ConsoleInput();
    
    private static String DEFAULT_INPUT = "DEFAULT_INPUT";
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private ConsoleInput(){
    }
    
    public static ConsoleInput getInputInstance(){
        return inputInstance;
    }

    @Override    
    public  void waitForInput() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String getInput() {
        String result = DEFAULT_INPUT;
        try{
            result = br.readLine();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        if(result.equals(DEFAULT_INPUT)){
            result = SystemMessages.ERROR_IN_INPUT;
        }
        
        return result;
    }
    
}
