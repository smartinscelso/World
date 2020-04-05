package earth;

import database.MySQLCountryDAO;
import enums.Continent;
import java.util.*;

/**
 *
 * celsoM_2017216
 */

public final class Menu {
    
    // Setting variables private to be used only inside Menu
    private String cCode; 
    private String name;
    private String continent;
    private float area;
    private String hoS;
    // String that will hold main Menu description
    private String mainMenu = ("-----------| MENU |-------------\n"
            + "[1] List All Countries\n"
            + "[2] Search by Country-code\n"
            + "[3] Search by Name\n"
            + "[4] Add a New Country\n"
            + "[5] Exit\n");
    
    // Initializing Classes
    private Scanner scanner = new Scanner(System.in);
    private MySQLCountryDAO dao = new MySQLCountryDAO();
    private final ArrayList<Country> countries = dao.getCountries(); // Final so the value can't be Overidded
    private Country country; 

    // Constructor has a switch to handle the user input for the menu
    // Closing database connection on the EXIT menu option because the program keeps running until the user quit.
    public Menu() {
        int choice = 0;
        // do-while loop to bring the user back to menu after methods execution
        do {
            
            try {
                System.out.println(mainMenu);
                System.out.print("Choice: ");

                choice = scanner.nextInt(); // gets user int input for menu option 
                System.out.println("--------------------------------");

                // Switch execute methods according to user input
                // variables cCode, name... etc, store values to be computed by methods
                switch (choice) {
                    case 1:
                        listAllCountries();
                        
                        break;
                    case 2:
                        System.out.print("Please enter the (3 CHAR) Country-code: ");
                        cCode = scanner.next();
                        searchByCode(cCode);
                        
                        break;
                    case 3:
                        System.out.println("Please enter the name of the Country: ");
                        name = scanner.next();
                        searchByName(name);
                        
                        break;
                    case 4:
                        addNewCountry();
                        
                        break;
                    case 5:
                        scanner.close();
                        // execute method in MySQLCountryDAO which executes DataSource closing method.
                        dao.closeDBConnecction(); 
                        System.out.println("Thanks for Visiting Earth!");
                        System.exit(0);
                        
                        break;
                    default:
                        System.out.println("No options match your input");
                        System.out.println("Please, try again");

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, try again");
            }
        } while (choice != 5);

    }
    
    // method uses functional operation to print elements of ArrayList<Countries>
    public void listAllCountries() {
        countries.forEach((c) -> {
            System.out.println(c);
        });
        System.out.println("");
    }
    
    // method receives user input for country-code and transfer value to MySQLCountryDAO for data retrieval
    public void searchByCode(String cCode) {
        country = dao.searchCountryByCode(cCode);
        // if country returned is not empty / if there is a result for country searched, print it.
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }
        System.out.println("");

    }
    
    // method receives user input for name and transfer value to MySQLCountryDAO for data retrieval
    public void searchByName(String name) {
        country = dao.searchCountryByName(name);
        // if country returned is not empty / if there is a result for country searched, print it.
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }
        System.out.println("");
    }

    // method receives user input for new Country and transfer value to MySQLCountryDAO for data insertion
    
    public void addNewCountry() {
        int input; //variabe to handle the input for Continent
        //try-catch add input values to variables and create new country through MySQLCountryDAO class
        try {
            System.out.println("Enter the (3-dig) Country-code: ");
            cCode = scanner.next();
            System.out.println("Enter the name of the Country: ");
            name = scanner.next();
            // User is provided of one of the options for continent, it makes easier to select enum value and add to DB
            System.out.println("Enter the No of the Continent: \n"
                    + "[1] Africa \n"
                    + "[2] Antarctica \n"
                    + "[3] Asia \n"
                    + "[4] Europe \n"
                    + "[5] North America \n"
                    + "[6] Oceania \n"
                    + "[7] South America \n"
            );
            
            // do-while loop so to force right user input
                input = scanner.nextInt();
                // Switch add enum value to variable continent
                switch (input) {
                    case 1:
                        continent = Continent.AFRICA.toString();
                        break;
                    case 2:
                        continent = Continent.ANTARCTICA.toString();
                        break;
                    case 3:
                        continent = Continent.ASIA.toString();
                        break;
                    case 4:
                        continent = Continent.EUROPE.toString();
                        break;
                    case 5:
                        continent = Continent.NORTH_AMERICA.toString();
                        break;
                    case 6:
                        continent = Continent.OCEANIA.toString();
                        break;
                    case 7:
                        continent = Continent.SOUTH_AMERICA.toString();
                        break;
                    default:
                        System.out.println("No options match your input");
                        System.out.println("Please, try again");
                        break;
                }
            
            System.out.println("Enter enter the Surface Area: ");
            area = scanner.nextFloat();
            System.out.println("Enter the Head of State: ");
            hoS = scanner.next();
            System.out.println("");
            // instantiate new Country using Country inner class BuilderCountry (Builder Pattern)
            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(area)
                    .withHeadOfState(hoS)
                    .build();
            //country  = new Country (cCode, name, continent, area, hoS);
            boolean added = dao.addCountry(country); // variable gets return whether data insertion happened or not(true/false)
            if (added == true) {
                System.out.println("Country successfully added! ");
            } else {
                System.out.println("Error!");
            }
            
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("Please, try again: ");
        }
        System.out.println("");
    }
}
