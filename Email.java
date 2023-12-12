package emailapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String Email;
    private int mailBoxCapacity = 75;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    private static Scanner scanner = new Scanner(System.in);



    // CONSTRUCTOR TO RECIEVE THE FIRST AND LAST NAME

    Email() {
        System.out.println("Enter your first name; " );
        this.firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        this.lastName = scanner.nextLine();

    //CALL METHOD ASKING FOR THE DEPARTMENT
        this.department = setDepartment(); 

    //CALLS A METHOD THAT RETURNS THE RANDOM GENERATED PASSOWRD

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

    // COMBINE ELEMENTS TO GENERATE THE NEW HIRES EMAIL 
        this.Email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

        scanner.close();
    }

    // ASKS USER INPUT FOR DEPARTMENT CODE

    private String setDepartment() {
        System.out.println("Welcome " +firstName + ". Please enter your department code from the following list:\n1 for Sales \n2 for Development\n3 for Accounting\n0 for none\n");
            int depChoice = scanner.nextInt();
            if (depChoice == 1) {
                 return "sales"; 
            } else if (depChoice == 2) {
                return "dev"; 
            } else if (depChoice == 3) {
                return "acct"; 
            } else {return " "; }
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
    // CHANGE THE PASSWORD 
        public void changePassword(String password) {
            this.password = password;
        }

        // DISPLYS INFO TO THE USER
        
        public int getMailBoxCapacity() { return mailBoxCapacity;}
        public String getPassword() { return password; }
        public String showInfo() {
            return "DISPLAY NAME: " + firstName + " " + lastName +
                    "\nCOMPANY EMAIL: " + Email + 
                    "\nMAILBOX CAPACITY: " + mailBoxCapacity + "kb";
        }




    // Save email information to a text file
 
    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("First Name: " + firstName);
            writer.println("Last Name: " + lastName);
            writer.println("Password: " + password);
            writer.println("Department: " + department);
            writer.println("Email: " + Email);
            writer.println("Mailbox Capacity: " + mailBoxCapacity);

        }   catch (IOException e) {
            e.printStackTrace();
    }
}

    // Load email information from a text file
    public void loadFromFile(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "First Name":
                            this.firstName = value;
                            break;
                        case "Last Name":
                            this.lastName = value;
                            break;
                        case "Password":
                            this.password = value;
                            break;
                        case "Department":
                            this.department = value;
                            break;
                        case "Email":
                            this.Email = value;
                            break;
                        case "Mailbox Capacity":
                            this.mailBoxCapacity = Integer.parseInt(value);
                            break;
                    }
                }
            }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
}
}
