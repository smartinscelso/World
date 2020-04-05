package enums;

/**
 *
 * @author junio
 */
public enum Continent {
    ASIA("Asia"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    EUROPE("Europe"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica");

    private String continent;

    Continent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return this.continent;
    }

    
}
