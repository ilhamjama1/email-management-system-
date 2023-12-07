package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String Email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    // CONSTRUCTOR TO RECIEVE THE FIRST AND LAST NAME

    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    //CALL METHOD ASKING FOR THE DEPARTMENT
        this.department = setDepartment(); 

    //CALLS A METHOD THAT RETURNS THE RANDOM GENERATED PASSOWRD

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

    // COMBINE ELEMENTS TO GENERATE THE NEW HIRES EMAIL 
        this.Email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // ASKS FOR THE NEW HIRES DEPARTMENT 
    private String setDepartment() {
        System.out.println("New worker: " +firstName + ". Department Codes:\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none\n Enter your department code: ");
        try (Scanner in = new Scanner(System.in)) {
            int depChoice = in.nextInt();
            if (depChoice == 1) { return "sales"; }
            else if (depChoice == 2) {return "dev"; }
            else if (depChoice == 3) {return "acct"; }
            else {return " "; }
        }
    }
    
    // GENERATE RANDOM PASSWORD FOR EMAIL

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01233456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // SET MAILBOX CAPACITY 
        public void setMailboxCapacity(int capacity){
            this.mailBoxCapacity = capacity;
        }
    // SET THE ALTERNATE EMAIL 
        public void setAlternateEmail(String altEmail) {
        }

    // CHANGE THE PASSWORD 
        public void changePassword(String password) {
            this.password = password;
        }
        public int getMailBoxCapacity() { return mailBoxCapacity;}
        public String getAlternateEmail() { return alternateEmail(); }
        private String alternateEmail() {
            return null;
        }



        public String getPassword() { return password; }

        public String showInfo() {
            return "DISPLAY NAME: " + firstName + " " + lastName +
                    "\nCOMPANY EMAIL: " + Email + 
                    "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
        }
    }
