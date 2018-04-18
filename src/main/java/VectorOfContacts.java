/********************
 Hambartzum Gamburian
 VectorOfContacts.java
 **********************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class VectorOfContacts implements ContactBook {

    private int size;
    private int capacity;
    private int incrementCapacity;
    Contact[] contacts;
    Scanner input;
    File file1;

    //Default constructor
    public VectorOfContacts() {
        incrementCapacity = 10;
        capacity = incrementCapacity;
        size = 0;
        contacts = new Contact[capacity];
    }

    //Constructor with arguements
    public VectorOfContacts(int inCapacity) {
        incrementCapacity = inCapacity;
        capacity = incrementCapacity;
        size = 0;
        contacts = new Contact[capacity];
    }

    public int getSize() {
        return size;
    }

    //Checks to see whether the vector is empty or not
    public boolean isEmpty() {
        return (size == 0);
    }

    //Checks to see whether the vector is full or not
    public boolean isFull() {
        return (size == capacity);
    }


    public void tooString() {
        for (int i = 0; i < size; i++) {
            System.out.print(contacts[i] + " ");
        }
    }

    //Incrementing capacity of vector
    private void incrementCapacity() {
        Contact[] temp = new Contact[capacity + incrementCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = contacts[i];
        }
        capacity += incrementCapacity;
        contacts = temp;
    }

    //To read from file contacts.txt
    public void readInitialFromFile() {
        try {
            input = new Scanner(new File("contacts.txt"));

            while (input.hasNextLine()) {
                String line_str = input.nextLine();
                String[] contact_info = line_str.split(":");

                Contact contact_for_info = new Contact(contact_info[0],Long.parseLong(contact_info[1]),contact_info[2]);
                addContact(contact_for_info);
            }
        }

        catch(FileNotFoundException e) {
            System.out.println("The \"contacts.txt\" file is either corrupt or is not found.");
            return;
        }
    }

    //Writing to file contacts.txt
    public void writeFinalToFile() {
        file1 = new File("contacts.txt");
        try {
            PrintWriter output = new PrintWriter(file1);
            for (int i = 0; i < size; i++) {
                output.println(contacts[i].toString());
            }
            output.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("The \"contacts.txt\" file is either corrupt or is not found.");
            return;
        }
    }

    //Add contact method
    public void addContact(Contact c) {
        if (isFull())
            incrementCapacity();
        contacts[size] = c;
        size++;
    }

    //Delete contact method
    public void deleteContact(String nm) {
        nm = nm.replaceAll("remove ", "");
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (contacts[i].getName().toLowerCase().contains(nm.toLowerCase())) {
                index = i;
                System.out.println("You have successfully removed: " + contacts[i].toString());
                break;
            }
        }
        for (int j = index; j < size - 1; j++) {
            contacts[j] = contacts[j + 1];
        }
        size--;
    }

    public void showByName(String nm) {
        nm = nm.replaceAll("find name ", "");
        for (int i = 0; i < size; i++) {
            if (contacts[i].getName().toLowerCase().contains(nm.toLowerCase()))
                System.out.println(contacts[i].getName() + ": " + contacts[i].getPhoneNumber() + ": " + contacts[i].getComment());
        }
    }

    public void showByPhoneNumber(long pN) {
        for (int i = 0; i < size; i++) {
            if (contacts[i].getPhoneNumber() == pN)
                System.out.println(contacts[i].getName() + ": " + contacts[i].getPhoneNumber() + ": " + contacts[i].getComment());
        }
    }

    public void showByComment(String c) {
        c = c.replaceAll("find comment ", "");
        for (int i = 0; i < size; i++) {
            if (contacts[i].getComment().toLowerCase().contains(c.toLowerCase()))
                System.out.println(contacts[i].getName() + ": " + contacts[i].getPhoneNumber() + ": " + contacts[i].getComment());
        }
    }

    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(contacts[i] + " ");
        }
    }
}