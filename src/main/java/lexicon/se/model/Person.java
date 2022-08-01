package lexicon.se.model;

import lexicon.se.sequencers.PersonIdSequencer;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;
//
    public Person(String firstName, String lastName, String email, String username, String password, AppRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        AppUser user = new AppUser();
//        this.setCredentials(appUser);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        id=PersonIdSequencer.nextId();
    }

    public int getId(){
        return id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

//    public void setCredentials(AppUser appUser){
//        this.credentials = appUser;
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
