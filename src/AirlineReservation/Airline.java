package AirlineReservation;

public class Airline {
    private Person[] seats;

    public Airline(){
        this.seats = new Person[11];
    }

    public void createReservation(Person person){
        int seatNumber =person.getSeatNumber()-1;

        while(seats[seatNumber] != null){
            System.out.println("\n" + person.getName() + ", seat: " + person.getSeatNumber() + " is already taken. " +
                    "Please choose another seat \n");
            person.chooseSeat();
            seatNumber =person.getSeatNumber()-1;
        }

        seats[seatNumber] = new Person(person);
        System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is " + person.getSeatNumber());

    }

    public Person getPerson(int index) {
        return new Person(this.seats[index]);
    }

    public void setPerson(Person person) {
        int seatNumber = person.getSeatNumber()-1;
        this.seats[seatNumber] = new Person(person);
        
    }
    public void displayAirline(){
        for (Person item: seats) {
            System.out.println("Seat number " + item.getSeatNumber() + " is occupied by " + item.getName());
            
        }
    }

    public void testSeats(int index){
       System.out.println(seats[index].toString());

    }

    public String toString(){
        String temp = "";

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != null){
                temp += seats[i].toString();
                temp += "\n \n";
            }
        }
        return temp;
    }
}
