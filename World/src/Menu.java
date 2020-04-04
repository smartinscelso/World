
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
    private String mainMenu = ("------Welcome to Earth----------\n"
            + "-----------| MENU |-------------\n"
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
                        System.out.println("-----------Add a New Country----------");
                        System.out.println("Please enter the (3-dig) Country-code: ");
                        cCode = scanner.next();
                        System.out.println("Please enter the name of the Country: ");
                        name = scanner.next();
                        try {
                            int c;
                            System.out.println("Please choose the continent: ");
                            System.out.println("[1] Africa");
                            System.out.println("[2] Asia");
                            System.out.println("[3] North America");
                            System.out.println("[4] South America");
                            System.out.println("[5] Oceania");
                            System.out.println("[6] Europe");
                            System.out.println("[7] Antarctica");
                            System.out.println("");
                            c = scanner.nextInt();
                            if (c == 1) {
                                continent = "AFRICA";
                            } else if (c == 2) {
                                continent = "ASIA";
                            } else if (c == 3) {
                                continent = "NORTH_AMERICA";
                            } else if (c == 4) {
                                continent = "SOUTH_AMERICA";
                            } else if (c == 5) {
                                continent = "OCEANIA";
                            } else if (c == 6) {
                                continent = "EUROPE";
                            } else if (c == 7) {
                                continent = "ANTARCTICA";
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Please, try again: ");
                            scanner.nextInt();
                        }
                        System.out.println("Please enter the Surface Area: ");
                        area = scanner.nextFloat();
                        System.out.println("Please enter the Head of State: ");
                        hoS = scanner.next();
                        System.out.println("Please wait... ");
                        //Country.BuilderCountry builder = new Country.BuilderCountry(cCode, name, continent);
                        //Country newCountry = builder.build();
                        System.out.println("Country successfully added! ");

                        return;
                    case 5:
                        scanner.close();
                        System.exit(0);

                        break;
                    default:
                        System.out.println("");
                        System.out.println("No options match your input");
                        System.out.println("Please, try again");

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, try again");
                scanner.next();
            }
        } while (choice != 6);

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

    public void searchByName(String Name) {
        country = dao.searchCountryByName(name);
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }
    }

    public Country addNewCountry(Country c) {
        return c;
    }
}
