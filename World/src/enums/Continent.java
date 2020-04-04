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
        ANTARCTICA("Antarctca");
        
        private String continent;
        
        Continent (String continent){
            this.continent = continent;
        }
    
        public String getContinent(){
            return continent;
        }
}
