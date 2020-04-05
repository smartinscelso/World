
import database.Country;
import enums.Continent;
import java.util.ArrayList;

public class World {

    //private static Menu menu;
    MySQLCountryDAO dao = new MySQLCountryDAO();
    
    public World(String name) {
        Country country = dao.searchCountryByName(name);
        if (country != null) {
            System.out.println(country);
        } else {
            System.out.println("No options match your input");
            System.out.println("Please, try again");
        }
    }
    public static void main(String[] args) {
        
        //World w = new World ("66");
        //World world = new World("Brazil");
       System.out.println("---------Welcome to Earth----------\n");
       Menu menu = new Menu();
        // NOW THE CLIENT DOES NOT HAVE ANYTHING TO DO
        // THE THE DATABASE CLASS.
        // THE CLIENT WILL ONLY TALK TO THE CUSTOMERDAO
        // IN TERMS OF CUSTOMER
        // IN OTHER WORDS, THE PASSING OF DATA IS GOING
        // TO BE CUSTOMERS OBJECTS
        // CountryDAO db = new MySQLCountryDAO();
        /*
        // GETTING ONLY THE CUSTOMER THAT HAS THE GIVEN
        // ID
        Country c = db.searchCountryByCode(55);
        Country c = db.searchCountryByName("Brazeeeel");
        // PRINTING IT TO THE CONSOLE
        System.out.println(c);
        // CREATING A NEW CUSTOMER. KEEP IN MIND THAT
        // THE ID OF THE NEW CUSTOMER IS GOING TO BE THE
        // SIZE OF THE ARRAY PLUS ONE
        Country newCountry = new Country(countries.size() + 55, "Brazeeeel", "South America", 2000.35, "Bolsonety");
        // ADDING THE CUSTOMER TO THE ARRAY, TO HAVE LOCAL
        // CONTROL OF THE DATA
        countries.add(newCountry);
        // ADDING THE NEW CUSTOMER INTO THE DATABASE
        System.out.println(db.saveCountry(newCountry));
         */
    }

}
