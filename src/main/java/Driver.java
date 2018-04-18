/********************
 Hambartzum Gamburian
 Driver.java
 **********************/

import java.util.Scanner;
import java.io.File;

public class Driver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        File file = new File("contacts.txt"); //Creating a new file
        String cmd;

        System.out.println("Welcome to Contact Book. \nWould you like to use a vector or an ordered vector?");
        System.out.println("Enter \"vector\" or \"ordered vector\".");
        cmd = input.nextLine(); //Waiting for response from user

        switch(cmd) {

            case "vector": VectorOfContacts vector = new VectorOfContacts();
                //Reading data from file
                if (file.exists())
                    vector.readInitialFromFile();

                //If quit is entered then the loop is ended
                while (!cmd.equals("quit")) {
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Enter a command: add, show all, find name, find phone, find comment, remove, or quit");
                    cmd = input.nextLine();

                    //Allowing user to add a contact
                    if (cmd.contains("add")) {
                        Contact newContact = new Contact();
                        vector.addContact(newContact);
                    }

                    //Allowing user to find a contact
                    if (cmd.contains("find")) {

                        if (cmd.contains("name")) {
                            vector.showByName(cmd);
                        }

                        if (cmd.contains("phone")) {
                            cmd = cmd.replaceAll("find phone ", "");
                            long pN = Long.valueOf(cmd);
                            vector.showByPhoneNumber(pN);
                        }

                        if (cmd.contains("comment")) {
                            vector.showByComment(cmd);
                        }
                    }

                    //Allowing user to remove a contact
                    if (cmd.contains("remove")) {
                        vector.deleteContact(cmd);
                    }

                    if (cmd.contains("show all")) {
                        vector.showAll();
                    }

                }//End of loop

                System.out.println("Writing to \"contacts.txt\" file. Goodbye...");
                vector.writeFinalToFile();
                break; //End of case

            case "ordered vector": OrderedVectorOfContacts orderedVector = new OrderedVectorOfContacts();
                //Reading data from file
                if (file.exists())
                    orderedVector.readInitialFromFile();

                //If quit is entered then the loop is ended
                while (!cmd.equals("quit")) {
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Enter a command: add, show all, find name, find phone, find comment, remove, or quit");
                    cmd = input.nextLine();

                    //Allowing user to add a contact
                    if (cmd.contains("add")) {
                        Contact newContact = new Contact();
                        orderedVector.addContact(newContact);
                    }

                    if (cmd.contains("find")) {

                        if (cmd.contains("name")) {
                            orderedVector.showByName(cmd);
                        }

                        if (cmd.contains("phone")) {
                            cmd = cmd.replaceAll("find phone ", "");
                            long pN = Long.valueOf(cmd);
                            orderedVector.showByPhoneNumber(pN);
                        }

                        if (cmd.contains("comment")) {
                            orderedVector.showByComment(cmd);
                        }
                    }

                    //Allowing user to remove a contact
                    if (cmd.contains("remove")) {
                        orderedVector.deleteContact(cmd);
                    }

                    if (cmd.contains("show all")) {
                        orderedVector.showAll();
                    }

                }//End of loop


                System.out.println("Writing to \"contacts.txt\" file. Goodbye...");
                orderedVector.writeFinalToFile();
                break; //End of case
        } //End of switch
    } //End of main method
} //End of class