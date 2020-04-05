package database;

public class Country {

    private String cCode;
    private String name;
    private String continent;
    private float surfaceArea;
    private String headOfState;

    private Country(BuilderCountry builder) {
        this.cCode = builder.cCode;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

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

    public static class BuilderCountry {

        private String cCode;
        private String name;
        private String continent;
        private float surfaceArea;
        private String headOfState;

        public BuilderCountry(String cCode, String name) {
            this.cCode = cCode;
            this.name = name;
            //this.continent = "Asia";
            //this.surfaceArea = 0.0f;
            //this.headOfState = null;
        }
        
        public BuilderCountry withContinent (String continent){
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

        public Country build() {
            return new Country(this);
        }
    }

    @Override
    public String toString() {
        return "COUNTRY CODE: " + cCode + ", COUNTRY: " + name + ", CONTINENT: " + continent + ", SURFACE AREA: " + surfaceArea + ", HEAD OF STATE: " + headOfState;
    }

}
