
public class Country {

    private String cCode;
    private String name;
    private String continent;
    private float surfaceArea;
    private String headOfState;

    Country(String cCode, String name, String continent, float surfaceArea, String headOfState ) {
        this.cCode = cCode; //builder.cCode;
        this.name = name;       //builder.name;
        this.continent = continent;      //builder.continent;
        this.surfaceArea = surfaceArea;           //builder.surfaceArea;
        this.headOfState = headOfState;
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

    /*public static class BuilderCountry {

        private String cCode;
        private String name;
        private String continent;
        private float surfaceArea;
        private String headOfState;

        public BuilderCountry(String cCode, String name, String continent) {
            this.cCode = cCode;
            this.name = name;
            this.continent = "Asia";
            this.surfaceArea = 0.0f;
            this.headOfState = null;
        }

        public String getCode() {
            return cCode;
        }

        public BuilderCountry setCode(String cCode) {
            this.cCode = cCode;
            return this;
        }

        public String getName() {
            return name;
        }

        public BuilderCountry setName(String name) {
            this.name = name;
            return this;
        }

        public String getContinent() {
            Continent valueOf = Continent.valueOf(continent);
            continent = valueOf.toString();
            return continent;

        }

        public BuilderCountry setContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public float getArea() {
            return surfaceArea;
        }

        public String getHeadOfState() {
            return headOfState;
        }

        public BuilderCountry setSurfaceArea(float surfaceArea) {
            this.surfaceArea = surfaceArea;
            return this;
        }

        public BuilderCountry setHeadOfState(String headOfState) {
            this.headOfState = headOfState;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }*/

    @Override
    public String toString() {
        return "COUNTRY CODE: " + cCode + ", COUNTRY: " + name + ", CONTINENT: " + continent + ", SURFACE AREA: " + surfaceArea + ", HEAD OF STATE: " + headOfState;
    }

}
