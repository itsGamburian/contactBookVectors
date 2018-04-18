/********************
 Hambartzum Gamburian
 Contact.java
 **********************/

import java.util.Scanner;

public class Contact {

    private String name;
    private long phoneNumber;
    private String comment;
    Scanner input;

    //Default constructor
    public Contact() {
        input = new Scanner(System.in);
        System.out.println("Name?");
        name = input.nextLine();
        System.out.println("Phone Number?");
        phoneNumber = input.nextLong();
        input.nextLine();
        System.out.println("Comment?");
        comment = input.nextLine();
    }

    //Constructor with arguments
    public Contact(String newName, long newPhoneNumber, String newComment) {
        name = newName;
        phoneNumber = newPhoneNumber;
        comment = newComment;
    }

    public String toString() {
        return name + ":" + phoneNumber + ":" + comment;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String newName1) {
        name = newName1;
    }

    public void setPhoneNumber(long newPhoneNumber1) {
        phoneNumber = newPhoneNumber1;
    }

    public void setComment(String newComment1) {
        comment = newComment1;
    }
}