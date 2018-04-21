package rms.io.output;

/**
 * Output will be printed to the console
 * @author blagiev
 */
public class ConsoleOutput implements Output{
    
    private static ConsoleOutput consoleOutputInstance = new ConsoleOutput();
    
    private ConsoleOutput(){}
    
    public static ConsoleOutput getInstance(){
        return consoleOutputInstance;
    }
    
    public void showOutput(String output){
        System.out.println(output);
    }
}
