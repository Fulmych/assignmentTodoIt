package lexicon.se.data_access;

import lexicon.se.model.AppRole;
import lexicon.se.model.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppUserDAOListTest {
    private final List<AppUser> appUsers = new ArrayList<>();
    AppUser a = new AppUser();

    @Test
    void persist() {
        a.setUsername("Bob");
        a.setPassword("Langa");
        a.setRole(AppRole.ROLE_APP_USER);
        appUsers.add(a);
        Assertions.assertEquals(1, appUsers.size());
    }

    @Test
    void findByUsername() {
        a.setUsername("Bob");
        a.setPassword("Langa");
        a.setRole(AppRole.ROLE_APP_USER);
        appUsers.add(a);
        Assertions.assertEquals(a, appUsers.stream()
                .filter(appUser -> appUser.getUsername().equalsIgnoreCase(a.getUsername()))
                .map(AppUser.class::cast)
                .findAny()
                .orElse(null));
    }

    @Test
    void findAll() {
        a.setUsername("Bob");
        a.setPassword("Langa");
        a.setRole(AppRole.ROLE_APP_USER);
        appUsers.add(a);
        Assertions.assertEquals(appUsers, appUsers);
    }

    @Test
    void remove() {
        a.setUsername("Bob");
        a.setPassword("Langa");
        a.setRole(AppRole.ROLE_APP_USER);
        appUsers.add(a);
        appUsers.removeIf(appUser -> appUser.getUsername().equalsIgnoreCase(a.getUsername()));
        Assertions.assertEquals(0, appUsers.size());
    }
}