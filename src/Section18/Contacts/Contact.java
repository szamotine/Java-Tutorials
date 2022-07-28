package Section18.Contacts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public Contact(){};

    public Contact(String name, String birthDate, String phoneNumber) throws ParseException {
       nameCheck(name);
       phoneNumberCheck(phoneNumber);

        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age= toAge(birthDate);
    }
    public Contact(Contact source){
        this.name = source.name;
        this.birthDate = source.birthDate;
        this.phoneNumber = source.phoneNumber;
        this.age = source.age;
    }

    public String toString(){
        return "\n --------Contact Details --------"
                + "\nName: " + this.name
                + "\nAge: " + this.age
                + "\nbirthDate: " + this.birthDate
                + "\nphoneNumber: " + this.phoneNumber
                + "\n--------End Contact Details --------\n";
    }

    /**
     * Name: toAge
     * @param birthDate :
     * @return age (int)
     * @throws ParseException
     *
     * Inside the function:
     *      1. Parses a date from the birthDate String
     *      2. Gets the current date
     *      3. Subtracts the difference and returns the age
     */

    private int toAge(String birthDate) throws ParseException  {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); // age in milliseconds

        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);

    }

    private void nameCheck(String name){
        if (name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
    }

    private void phoneNumberCheck(String phoneNumber){
        if (phoneNumber.isBlank() || phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null/blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number cannot be less than 5 characters");
        }
    }

//region Getters, Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        nameCheck(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberCheck(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    //endregion
}
