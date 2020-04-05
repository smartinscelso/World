import database.Country;
import java.util.ArrayList;

public interface CountryDAO {

	public ArrayList<Country> getCountries();
	public Country searchCountryByCode(String cCode);
	public Country searchCountryByName(String name);
	public boolean addCountry(Country country);
}
