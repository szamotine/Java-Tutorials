package AirlineReservation;

import java.util.Arrays;

public class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

   public Person(String name, String nationality, String dateofBirth, int seatNumber){
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateofBirth;
        this.seatNumber = seatNumber;
        this.passport = new String[3];
    }

    public Person(Person source){
       this.name = source.name;
       this.nationality = source.nationality;;
       this.dateOfBirth = source.dateOfBirth;
       this.seatNumber = source.seatNumber;
       this.passport = Arrays.copyOf(source.passport, source.passport.length);
    }

    /**
     * Function name: applyPassport
     * @return (boolean)
     *
     * Inside the function:
     *      1. Returns a random boolean of true or false
     *
     */
    public boolean applyPassport(){
        int random = (int)(Math.random()*2);

        if (random == 1){
            return true;
        }else{
            return false;
        }

    }

    /**
     * Function name: chooseSeat
     *
     * Inside the function:
     *      1. sets this.seat to a random number between 1-11.
     */
    public void chooseSeat(){
        this.seatNumber = (int)(Math.random()*11 + 1);

    }


    public void printPerson(){
        System.out.println(name);
        System.out.println(nationality);
        System.out.println(dateOfBirth);
        System.out.println(Arrays.toString(passport));
        System.out.println(seatNumber);
    }

    public String toString(){
       return    "\n" + "Name: " + name
               + "\n" + "Nationality: " + nationality
               + "\n" + "Date of Birth: " + dateOfBirth
               + "\n" + "Seat Number: " + seatNumber
               + "\n" + "Passport: " + Arrays.toString(passport);
    }
    //region Getter/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getPassport() {
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public void setPassport() {
        this.passport = new String[] {this.name, this.nationality, this.dateOfBirth};
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    //endregion
}
