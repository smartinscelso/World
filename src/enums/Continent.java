package enums;

/**
 * 
 * @author celsoM_2017216
 */

public enum Continent {
    ASIA("Asia"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    EUROPE("Europe"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica");

    private String continent; //variable to hold enum value

    Continent(String continent) {
        this.continent = continent;
    }

    //Overriding to get continent Enum value
    @Override 
    public String toString() {
        return this.continent;
    }

    
}
