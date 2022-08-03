package lexicon.se.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lexicon.se.active.FileCreation;
import lexicon.se.sequencers.PersonIdSequencer;

import java.io.File;
import java.util.Objects;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    @JsonCreator
    public Person( @JsonProperty("firstName")String firstName, @JsonProperty("lastName")String lastName, @JsonProperty("email")String email, @JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("role") AppRole role) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        AppUser user = new AppUser();
        setCredentials(user);
        setUsername(username);
        setPassword(password);
        setRole(role);
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
    public void setCredentials(AppUser credential) {
        credentials = credential;
    }
    public void setUsername(String username){ credentials.setUsername(username);}
    public void setPassword(String password){ credentials.setPassword(password);}
    public void setRole(AppRole role){ credentials.setRole(role);}
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
