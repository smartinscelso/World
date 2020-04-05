
import database.Country;
import database.DataSourceSingleton;
import enums.Continent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author junio
 */
public final class Menu {

    private String cCode;
    private String name;
    private String continent;
    private float area;
    private String hoS;
    private String mainMenu = ("-----------| MENU |-------------\n"
            + "[1] List All Countries\n"
            + "[2] Search by Country-code\n"
            + "[3] Search by Name\n"
            + "[4] Add a New Country\n"
            + "[5] Exit\n");

    private Scanner scanner = new Scanner(System.in);
    private MySQLCountryDAO dao = new MySQLCountryDAO();
    ArrayList<Country> countries = dao.getCountries();
    private Country country;

    public Menu() {
        int choice = 0;
        do {
            try {
                System.out.println(mainMenu);
                System.out.print("Choice: ");

                choice = scanner.nextInt();
                System.out.println("--------------------------------");

                int r = 0;
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
                scanner.next();
            }
        } while (choice != 5);

    }

    public void listAllCountries() {
        for (Country c : countries) {
            System.out.println(c);
        }
        System.out.println("");
    }

    public void searchByCode(String cCode) {
        country = dao.searchCountryByCode(cCode);
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }

    }

    public void searchByName(String name) {
        this.name = name;
        country = dao.searchCountryByName(name);
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }
    }

    public void addNewCountry() {
        int input;
        try {
            System.out.println("Enter the (3-dig) Country-code: ");
            cCode = scanner.next();
            System.out.println("Enter the name of the Country: ");
            name = scanner.next();
            System.out.println("Enter the No of the Continent: \n"
                    + "[1] Africa \n"
                    + "[2] Antarctica \n"
                    + "[3] Asia \n"
                    + "[4] Europe \n"
                    + "[5] North America \n"
                    + "[6] Oceania \n"
                    + "[7] South America \n"
            );
            input = scanner.nextInt();
            do {
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
            } while (input != 5);
            System.out.println("Enter enter the Surface Area: ");
            area = scanner.nextFloat();
            System.out.println("Enter the Head of State: ");
            hoS = scanner.next();
            System.out.println("");
            
            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(area)
                    .withHeadOfState(hoS)
                    .build();
            //country  = new Country (cCode, name, continent, area, hoS);
            boolean added = dao.addCountry(country);

            if (added == true) {
                System.out.println("Country successfully added! ");
            } else {
                System.out.println("Error!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please, try again: ");
        }
    }
}
