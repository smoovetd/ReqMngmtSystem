package rms.ui;

/**
 * Interface that will hold method display() - for all menu levels
 * @author blagiev
 */
public interface Menu {
    public void show();
    
    public void displayWellcomeMessage();
    
    public boolean getInput();
}
