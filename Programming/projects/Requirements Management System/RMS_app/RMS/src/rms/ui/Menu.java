package rms.ui;

import java.util.HashMap;
import rms.io.output.Output;

/**
 * Interface that will hold method display() - for all menu levels
 * @author blagiev
 */
public interface Menu {
    public void show(Output output);
    
    public HashMap<Integer, String> getMenuItems();
}
