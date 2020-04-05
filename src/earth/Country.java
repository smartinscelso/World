package earth;

/**
 * Referencing: Code written following examples given in class by @Apont.
 * Builder Pattern is Implemented here
 * @author celsoM_2017216
 */

public class Country{

    // Variables to store country attributes from Database Columns
    private String cCode;
    private String name;
    private String continent;
    private float surfaceArea;
    private String headOfState;

    // Constructor is set private so class can only be instantiated
    // by builder Inner class. (Receice as param The inner Class BuilderCountry) 
    private Country(BuilderCountry builder) {
        // Variables in this Constructor = variables received as param by builder
        this.cCode = builder.cCode;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

    // SETTERS AND GETTERS
    
    public String getCode() {
        return cCode;
    }

    public void setCode(String cCode) {
        this.cCode = cCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        //Continent valueOf = Continent.valueOf(continent);
        //continent = valueOf.toString();
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public float getArea() {
        return surfaceArea;
    }

    public void setArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    // Builder inner class is set STATIC so it can access private
    // elements of the outer class that it is building.
    public static class BuilderCountry {

        private String cCode;
        private String name;
        private String continent;
        private float surfaceArea;
        private String headOfState;

        // public constructor to allow instantiation from outside
        // I setted just code and name as "main param" for being the principal attributes
        // however it could have been only cCode or more than 2 parameters.
        public BuilderCountry(String cCode, String name) {
            this.cCode = cCode;
            this.name = name;
            this.continent = "Asia";
            this.surfaceArea = 0.0f;
            this.headOfState = null;
        }
        
        // SETTERS. Using WITH to differ name from Setters in  OuterClass
        public BuilderCountry withContinent(String continent){
            this.continent = continent;
            return this;
        }

        public BuilderCountry withArea(float surfaceArea) {
            this.surfaceArea = surfaceArea;
            return this;
        }
        
         public BuilderCountry withHeadOfState(String headOfState) {
            this.headOfState = headOfState;
            return this;
        }

        // The method that actually build the Country Class.
        public Country build() {
            // Returning current instance
            return new Country(this);
        }
    }
    
    // Method  to add Columns before values so it can be printed as a String shown below.
    @Override
    public String toString() {
        return "COUNTRY CODE: " + cCode + ", COUNTRY: " + name + ", CONTINENT: " + continent + ", SURFACE AREA: " + surfaceArea + ", HEAD OF STATE: " + headOfState;
    }

}
