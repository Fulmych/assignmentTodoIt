package lexicon.se.data_access;

import lexicon.se.model.AppUser;
import lexicon.se.model.TodoItemTask;

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
        return appUsers.stream()
                .filter(appUser -> appUser.getUsername().equalsIgnoreCase(username))
                .map(AppUser.class::cast)
                .findAny()
                .orElse(null);
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
