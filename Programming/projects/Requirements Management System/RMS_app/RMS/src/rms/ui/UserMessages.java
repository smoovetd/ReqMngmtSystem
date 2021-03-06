package rms.ui;

/**
 * This class will hold and provide messages that should be displayed to the user
 * @author blagiev
 */
public class UserMessages {
    
    private static UserMessages userMessagesInstance = new UserMessages();
    
    private static final String WELLCOME_MESSAGE = "WELLCOME\nto\nRequirements Management Software";
    private static final String GOODBYE_MESSAGE = "Closing Requirements Management Software\nGoodbye";
    private static final String NO_PROJECT_FOUND = "No project found. Proceed with opening new project";

        
    private UserMessages(){};
    
    public static UserMessages getInstance(){
        return userMessagesInstance;
    }
    
    public static String getWellcomeMessage(){
        return WELLCOME_MESSAGE;
    }
    
    public static String getGoodbyeMessage(){
        return GOODBYE_MESSAGE;
    }
    
    public static String getNoProjectFoundMessage(){
        return NO_PROJECT_FOUND;
    }
}
