package database;

import earth.Country;
import interfaces.CountryDAO;
import java.sql.*;
import java.util.*;

/**
 * Referencing: Code modified from MySQLCustomerDAO.java given in class by @apont.
 * @author celsoM_2017216
 */

// CLASS FOR INTERACTION WITH DATASOURCE
// .closing(); removed from methods. The only way to close DB Connection is Quiting program on MENU.
// Close DB method added here.
public class MySQLCountryDAO implements CountryDAO { // Implements interface with pre-set methods

    // private Datasource instantiation to be used only inside this class
    private DataSourceSingleton dSource = DataSourceSingleton.getIntance(); 
     
    // METHOD 1: GET ALL COUNTRIES
    @Override
    public ArrayList<Country> getCountries() {
        Country country;
        // CREATE THE ARRAYLIST TO PUT ALL THE CUSTOMERS
        // THAT ARE GOING TO BE RETURNED
        ArrayList<Country> countries = new ArrayList<>();

        // THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
        String query = "select * from country";

        // ACCESSING THE DATABASE
        
        // QUERYING THE DATABASE
        ResultSet rs = dSource.select(query);

        // LOOP OVER THE RESULT SET
        try {
            while (rs.next()) {
                // FOR EACH ONE OF THE VALUES, WE WANT TO
                // GET THE ATTRIBTUES
                String cCode = rs.getString(1);
                String name = rs.getString(2);
                String continent = rs.getString(3);
                float surfaceArea = rs.getFloat(4);
                String headOfState = rs.getString(5);

                // New country is created using Builder Pattern so the attributes can be independently added to Country
                country = new Country.BuilderCountry(cCode, name)
                        .withContinent(continent)
                        .withArea(surfaceArea)
                        .withHeadOfState(headOfState)
                        .build();
                
                countries.add(country); //add to ArrayList
            }

            // CLOSING THE CONNECTION TO THE DATABASE
            //dSource.closing();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }

        // RETURN THE ARRAYLIST WITH ALL COUNTRIES
        return countries;
    }
    
    // METHOD 2: SEARCH COUNRY BY COUNTRY-CODE
    @Override
    public Country searchCountryByCode(String cCode) {
        // CREATING THE OBJECT THAT WE'RE GOING TO RETURN
        Country country = null;

        // THIS METHOD IS IN CHAGE OF CREATING THE QUERY
        String query = "select * from country where Code = '" + cCode + "'";

        // ACCESSING THE DATABASE
        dSource = DataSourceSingleton.getIntance();
        // QUERYING THE DATABASE
        
        ResultSet rs = dSource.select(query);

        // WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE 
        // OF CUSTOMER
        try {
            rs.next();
            String name = rs.getString(2);
            String continent = rs.getString(3);
            float surfaceArea = rs.getFloat(4);
            String headOfState = rs.getString(5);

            // New country is created using Builder Pattern so the attributes can be independently added to Country
            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(surfaceArea)
                    .withHeadOfState(headOfState)
                    .build();
        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        // RETURN THE COUNTRY 
        return country;
    }
    
    // METHOD 3: SEARCH COUNRY BY NAME
    @Override
    public Country searchCountryByName(String name) {

        // CREATING THE OBJECT THAT WE'RE GOING TO RETURN
        Country country = null;
        // THIS METHOD IS IN CHAGE OF CREATING THE QUERY
        String query = "select * from country where Name = '" + name + "'";

        // ACCESSING THE DATABASE
        dSource = DataSourceSingleton.getIntance();
        // QUERYING THE DATABASE
        ResultSet rs = dSource.select(query);

        // WITH THE RESULT GET THE DATA AND PUT IT IN THE INSTANCE
        // OF CUSTOMER
        try {
            rs.next();
            String cCode = rs.getString(1);
            String continent = rs.getString(3);
            float surfaceArea = rs.getFloat(4);
            String headOfState = rs.getString(5);
            
            // New country is created using Builder Pattern so the attributes can be independently added to Country
            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(surfaceArea)
                    .withHeadOfState(headOfState)
                    .build();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }

        // RETURN THE COUNTRY
        return country;
    }

    @Override
    public boolean addCountry(Country country) {

        // ACCESSING THE DATABASE
        // FROM THE OBJECT, GETTING THE DATA
        String cCode = country.getCode();
        String name = country.getName();
        String continent = country.getContinent();
        double surfaceArea = country.getArea();
        String headOfState = country.getHeadOfState();

        // THIS METHOD IS IN CHARGE OF CREATING THE QUERY
        String query = "insert into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + cCode + "', '" + name + "', '" + continent + "', " + surfaceArea + ", '" + headOfState + "' )";

        // REQUESTION TO SAVE THE DATA
        boolean result = dSource.save(query);

        // CLOSING THE DATABASE
        //dSource.closing();

        return result;
    }
    
    /* METHOD 4: Close DB Connection
       It was removed from methods 1,2,3 because as the program keeps running,
       the connection needs to keep opened untill the end of the program.
       Change done because of SQLException: The statement is closed.
    */
       public void closeDBConnecction(){
        dSource.closing();
    }

}
