import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * This is the singleton class of the program.
 * As all the logs MUST go to the same file, there can't
 * be more than one instance of it. Otherwise there
 * will conflict of versions. 
 * 
 * @author apont
 *
 */
public class SingletonWritter {
	
	// The file writer needed to write to the file
	private FileWriter fw;
	private String file = "logs.txt";
		
	// Single instance that live here
	private static SingletonWritter instance = new SingletonWritter();
	
	// Private constructor
	private SingletonWritter() {
		try {
			// The second parameter, "true", allows us
			// to append data to the file without getting rid
			// of its content.
			// Try it with false to see what it does!!
			fw = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// Singleton getter!!!
	public static SingletonWritter getInstance() {
		return instance;
	}
	
	// This method will be in charge of writing 
	// a line to the console
	public void writeToFile(String log) {
		try {
			System.out.print(log);
			fw.write(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// This method is in charge of closing the writer
	// and saving the file with the updates
	public void close() {
		try {
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
}
