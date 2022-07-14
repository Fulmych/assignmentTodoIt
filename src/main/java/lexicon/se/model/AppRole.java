package lexicon.se.model;

public enum AppRole {
    ROLE_APP_USER("User"), ROLE_APP_ADMIN("Admin");
    private String roleName;
    AppRole(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}