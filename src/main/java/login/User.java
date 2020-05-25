package login;

public class User {
    private String username;
    private String password;
    private boolean banned;
    private String banReason;

    public User(String username, String password, String banReason, boolean banned)
    {
        this.username = username;
        this.password = password;
        this.banned = banned;
        this.banReason = banReason;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getBanReason() {
        return banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", banned=" + banned +
                ", banReason='" + banReason + '\'' +
                '}';
    }
}
