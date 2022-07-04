package lexicon.se;

public class Person {
    private static int uid = 0;
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    int getId(){
        return id;
    }
    void setFirstName(String firstName){
        this.id = uid++;
        this.firstName = firstName;
    }
    String getFirstName(){
        return firstName;
    }
    void setLastName(String lastName){
        this.lastName = lastName;
    }
    String getLastName(){
        return lastName;
    }
    void setEmail(String email){
        this.email = email;
    }
    String getEmail(){
        return email;
    }
    String getSummary(){
        String n = "";
        System.out.println("Id: " + id + "\n" + "Name: " + firstName + " " + lastName + "\n" + "Email: " + email);
        return n;
    }
}
