package AirlineReservation;


public class Main {
    public static void main(String[] args){

       /* Person person = new Person("Rayan Slim","Canadian","01/01/1111", 5);
        System.out.println(person.toString());
        person.chooseSeat();

        if (person.applyPassport()){
            System.out.println("Congratulations " + person.getName() + " your passport was approved");
            person.setPassport();
        }else{
            System.out.println("Sorry " + person.getName() + " your passport was not approved");
        }

        System.out.println(person.toString());
*/

        /*
        Person person2 = new Person(person);
        person.setSeatNumber(10);
        System.out.println(person.toString());
        System.out.println(person2.toString());
        */


        Person[] people = new Person[] {
                new Person("Cleopatra", "Egypt", "69 BC", 1),
                new Person("Alexander the Great", "Macedon", "356 BC", 1),
                new Person("Julius Caesar", "Rome", "100 BC", 1),
                new Person("Hannibal", "Carthage", "247 BC", 1),
                new Person("Confucius", "China", "551 BC", 2),
                new Person("Pericles", "Greece", "429 BC", 2),
                new Person("Spartacus", "Thrace", "111 BC", 2),
                new Person("Marcus Aurelius", "Rome", "121 AD", 2),
                new Person("Leonidas", "Greece", "540 BC", 2),
                new Person("Sun Tzu", "China", "544 BC", 2),
                new Person("Hammurabi", "Babylon", "1750 BC", 2),
        };

        Airline airline = new Airline();

        for (int i = 0; i < people.length; i++) {
            //airline.setPerson(people[i]);
            if (people[i].applyPassport()){
                people[i].setPassport();
                airline.createReservation(people[i]);
            }

        }

        System.out.println("\n--------Reservations complete----------- \n " + airline.toString());






        //person.printPerson();



    }
}
