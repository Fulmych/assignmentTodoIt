package lexicon.se.data_access;

import lexicon.se.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOList implements AppUserDAO{
    private final List<AppUser> appUsers = new ArrayList<>();

    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        return (AppUser) appUsers.stream().filter(appUser -> appUser.getUsername().equalsIgnoreCase(username));
    }

    @Override
    public List<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public void remove(String username) {
        appUsers.removeIf(appUser -> appUser.getUsername().equalsIgnoreCase(username));
    }
}
