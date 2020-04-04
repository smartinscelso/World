
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    // All four buttons of the window
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTable table;
    private MySQLCountryDAO dao;
    private DefaultTableModel model;
    private JPanel mainPanel;
    private ArrayList<Country> countries;
    private Container c;
    private Object[][] object;

    public View() {
        //Creating the panel that will be added to the frame
        model = new DefaultTableModel();
        table = new JTable(model);
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        c = new Container();
        object = new Object[03][03];

        // Add Columns to table
        model.addColumn("Country Code");
        model.addColumn("Name");
        model.addColumn("Continent");
        model.addColumn("Surface Area");
        model.addColumn("Head Of State");

        // Creating Buttons
        button1 = new JButton("List All");
        button2 = new JButton("Search by Country Code");
        button3 = new JButton("Search by Name");
        button4 = new JButton("Add a new Country");
        //Adding each but ton to the panel
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(table);

        // Identifying each one of the buttons
        button1.setActionCommand("b1");
        button2.setActionCommand("b2");
        button3.setActionCommand("b3");
        button4.setActionCommand("b4");

        // NOTICE  that here we are creating four different
        // instances of the ButtonListener class. This way
        // each button has its own action listener
        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());
        button4.addActionListener(new ButtonListener());

        // Creating an instance of the Window Listener
        // Build table Appointments
        dao = new MySQLCountryDAO();
        //countries = dao.getCountries();

        // GETTING ALL OF THE CUSTOMERS IN THE DATABASE
        ArrayList<Country> countries = dao.getCountries();

        // PRINTING THEM TO THE CONSOLE
        Iterator<Country> it = countries.iterator();
        while (it.hasNext()) {
            Country country = it.next();
            String cCode = country.getCode();
            String name = country.getName();
            String Continent = country.getContinent();
            float area = country.getArea();
            String hoS = country.getHeadOfState();
            model.addRow(new Object (" + cCode ", ));
        }
        listCustomers();         
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
for(int i = 0; i < listCustomers.size(); i+=2){
    Object[] rowdata = new Object[] {listCustomers.get(i), listCustomers.get(i+1)};

    model.addRow(rowdata);
        {
            it.remove();
            break;
        }
    }

    showDataInTable(listOfBooks, table);

}

/*try {
        while (countries.isEmpty()) {
        for (int i = 0; i < countries.size(); i++) {
        model.addRow(new Country[i]);
        System.out.println("hi");
        }
        }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Something went wrong...");
        }
 */
c = getContentPane();
    c.setLayout(new FlowLayout());

    JScrollPane scrollPane = new JScrollPane(table);
    c.add(mainPanel);
    c.add(scrollPane);
    
          
    }
    
}
