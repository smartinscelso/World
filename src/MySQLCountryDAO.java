
import database.DataSourceSingleton;
import database.Country;
import java.sql.*;
import java.util.*;

public class MySQLCountryDAO implements CountryDAO {

    private DataSourceSingleton dSource = DataSourceSingleton.getIntance();
    private Country country;

    // METHOD 1: GET ALL COUNTRIES
    @Override
    public ArrayList<Country> getCountries() {

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

                country = new Country.BuilderCountry(cCode, name)
                        .withContinent(continent)
                        .withArea(surfaceArea)
                        .withHeadOfState(headOfState)
                        .build();
                //Person person = new Person.Builder("Kevin", "G").country("Deutschland").build();
                //country = new Country(cCode, name, continent, surfaceArea, headOfState);
                countries.add(country);
            }

            // CLOSING THE CONNECTION TO THE DATABASE
            //dSource.closing();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // RETURN THE ARRAYLIST WITH ALL THE CUSTOMERS
        return countries;
    }

    @Override
    public Country searchCountryByCode(String cCode) {

        // CREATING THE OBJECT THAT WE'RE GOING TO RETURN
        //Country country = null;

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

            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(surfaceArea)
                    .withHeadOfState(headOfState)
                    .build();

            //country = new Country(cCode, name, continent, surfaceArea, headOfState);
            //country = new Country.BuilderCountry(cCode, name, continent).setSurfaceArea(surfaceArea).setHeadOfState(headOfState).build();
            // CLOSING THE CONNECTION TO THE DATABASE
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        // RETURN THE CUSTOMER 
        return country;
    }

    @Override
    public Country searchCountryByName(String name) {

        // CREATING THE OBJECT THAT WE'RE GOING TO RETURN

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

            country = new Country.BuilderCountry(cCode, name)
                    .withContinent(continent)
                    .withArea(surfaceArea)
                    .withHeadOfState(headOfState)
                    .build();
            // country = new Country(cCode, name, continent, surfaceArea, headOfState);
            // CLOSING THE CONNECTION TO THE DATABASE
            //dSource.closing();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }

        // RETURN THE CUSTOMER
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
    
    public void closeDBConnecction(){
        dSource.closing();
    }

}
