public class Address {
    
    private String zipcode;

    private String country;

    private String city;

    public Address(String zipcode, String country, String city) {
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String toString() {

        return "zipcode : " + getZipcode() + "\n\tcountry : " + getCountry() + "\n\tcity : " + getCity();
    }
}
