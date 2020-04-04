
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ButtonListener implements ActionListener {

    // Each instance of this class will have a reference to the
    // singleton writer object.
    // 
    SingletonWritter sw = SingletonWritter.getInstance();
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        switch()
// building the string that is going to be printed to the console
        String log = "Buttonccc " + arg0.getActionCommand() + " pressed. " + new Date() + "\n";
        // Using the singleton writer
        sw.writeToFile(log);

    }

}
