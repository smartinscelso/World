package interfaces;

import earth.Country;
import java.util.ArrayList;

/**
 * Referencing: Code modified from CustomerDAO.java given in class by @apont.
 * @author celsoM_2017216
 */

public interface CountryDAO {

	public ArrayList<Country> getCountries();
	public Country searchCountryByCode(String cCode);
	public Country searchCountryByName(String name);
	public boolean addCountry(Country country);
        
}
