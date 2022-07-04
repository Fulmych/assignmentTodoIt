package lexicon.se;

import java.util.Objects;

public class Person {
    private static int uid = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(String firstName, String lastName, String email, String username, String password, AppRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        credentials.setUsername(username);
        credentials.setPassword(password);
        credentials.setRole(role);
        this.id = uid++;
    }

    int getId(){
        return id;
    }
    void setFirstName(String firstName){
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

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(String username, String password, AppRole role) {
        credentials.setUsername(username);
        credentials.setPassword(password);
        credentials.setRole(role);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
