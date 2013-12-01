/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.11.13
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
public class Country {
    private String shortCode;
    private String fullName;
    private String capital;

    private Country(Builder builder){
        this.shortCode = builder.shortCode;
        this.capital = builder.capital;
        this.fullName = builder.fullName;
    }


    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!capital.equals(country.capital)) return false;
        if (!fullName.equals(country.fullName)) return false;
        if (!shortCode.equals(country.shortCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shortCode.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + capital.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "fullName='" + fullName + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    public static class Builder{

        private String shortCode;
        private String fullName;
        private String capital;

        public Builder(){

        }

        public Builder(Country country){
            this.capital = country.capital;
            this.fullName = country.fullName;
            this.shortCode = country.shortCode;
        }

        public Builder capital(String capital){
            this.capital = capital;
            return this;
        }

        public Builder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public Builder shortCode(String shortCode){
            this.shortCode = shortCode;
            return this;
        }

        public Country build(){
            return new Country(this);
        }
    }
}
