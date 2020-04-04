public class World {

    private static Menu menu;
    public static void main(String[] args) {
        menu = new Menu();
       
        
        //MySQLCountryDAO dao = new MySQLCountryDAO();
        //ArrayList<Country> countries = dao.getCountries();
        //System.out.println(countries.get(2));
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
