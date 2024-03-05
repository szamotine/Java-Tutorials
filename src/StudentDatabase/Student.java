package StudentDatabase;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private StudentID id;
    private List<Courses> enrolledCourses = new ArrayList<>(5);
    private int balance;

    //prompt user to enter name and year for each student
    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.balance = 0;
        id= new StudentID();
        id.GenerateID(year);
        showStatus();
    }



    // see the status of the student -> name, ID, courses enrolled, balance
    public void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id.getId());

        if (enrolledCourses != null && !enrolledCourses.isEmpty()) {
            System.out.println("Courses enrolled: ");

            for (Courses course : this.enrolledCourses) {
                System.out.println(course.name());
            }

        }

        System.out.println("Balance: " + balance);
    }

    public void addCourse(Courses course) {
        enrolledCourses.add(course);
        balance += 600;
    }
}


