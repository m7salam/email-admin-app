package me.mosalam;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";


    // constructor to receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for Department - return department
        this.department = setDepartment();

        // Call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + this.companySuffix ;
    }

    // Ask for department
    private String setDepartment() {
        System.out.println("New worker: " + this.firstName + "\nDepartment codes: \n1 for sales\n2 for development\n3 for accounting\n0 for None\nEnter the department: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "Sales"; }
        else if (departmentChoice == 2) { return "Development";}
        else if (departmentChoice == 3) {return "Accounting";}
        else { return ""; }
    }
    // Generate  a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_-+=";
        char[] password = new char[length];
        for (int i =0; i<length; i++) {
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
                "\nCOMPANY EMAIL: " + this.email +
                "\nMAILBOX CAPACITY: " + this.mailBoxCapacity + "mb";
    }
}
