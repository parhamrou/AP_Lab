public class PhoneNumber {
    
    private String countryCode;

    private String number;

    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        if (number.length() == 10) {
            this.number = number;
        } else {
            System.out.println("Your number is invalid!");
            this.number = "-";
        }
    }

    public String getCountryCode() {
        return countryCode;
    }
    
    public String getNumber() {
        return number;
    }

    public String toString() {
        if (!number.equals("-")){
            return "number : " + getCountryCode() + getNumber();
        } else {
            return "number : -";
        }
    }
}
