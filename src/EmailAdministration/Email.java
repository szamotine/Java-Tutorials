package EmailAdministration;

import java.util.Scanner;

public class Email {
    static final String COMPANY_SUFFIX = ".company.com";
    static final int EMAIL_LENGTH = 8;
   private String firstName;
    private String lastName;
    private String password;
    private String department;

    private String email;
    private int mailboxCapacity;
    private String alternateEmail;

    @Override
    public String toString() {
        return "Account created: " + "\nfirstName= " + firstName  + "\nlastName= " + lastName + "\npassword= " + password + "\ndepartment= " + department +
                "\nemail= " + email +  "\nmailboxCapacity= " + mailboxCapacity + "\nalternateEmail= " + alternateEmail ;
    }

    // constructor to receive the first and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // call a method asking for the department - return the department
        this.department = setDepartment();

        // generate random password
        this.password = randomPassword(EMAIL_LENGTH);

        // generate email
        email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + COMPANY_SUFFIX;

        System.out.println(this);
    }

    // ask for the department
    private String setDepartment()
    {
        System.out.println("Enter the  department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        in.close();

        switch(depChoice)
        {
            case 1:
                return "Sales";

            case 2:
                return "Development";

            case 3:
                return "Accounting";

            default:
                return "";

        }
    }
    // generate a random password
    private String randomPassword(int length)
    {
        String uppercaseSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseSet = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacterSet = "!@#$%^&*()=+";

        char[] password = new char[length];

        for(int i = 0; i < length; i++)
        {
            int randSet = (int) (Math.random()*3);
            int randChar;
            switch (randSet)
            {
                case 0:
                     randChar = (int) (Math.random()*uppercaseSet.length());
                    password[i] = uppercaseSet.charAt(randChar);
                    break;
                case 1:
                     randChar = (int) (Math.random()*lowercaseSet.length());
                    password[i] = lowercaseSet.charAt(randChar);
                    break;
                case 2:
                     randChar = (int) (Math.random()*specialCharacterSet.length());
                    password[i] = specialCharacterSet.charAt(randChar);
                    break;
            }
        }
        return new String(password);
    }
    // set the mailbox capacity
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    // set the alternate email
    public void setAlternateEmail(String email)
    {
        this.alternateEmail = email;
    }

    // change the password
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}
