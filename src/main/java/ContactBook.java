/********************
 Hambartzum Gamburian
 ContactBook.java
 **********************/

public interface ContactBook {

    public void readInitialFromFile();
    public void writeFinalToFile();
    public void addContact(Contact c);
    public void deleteContact(String nm);
    public void showByName(String nm);
    public void showByPhoneNumber(long pN);
    public void showByComment(String c);
}