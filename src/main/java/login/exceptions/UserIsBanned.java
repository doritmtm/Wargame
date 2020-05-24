package login.exceptions;
import login.User;

public class UserIsBanned extends Exception {
    private User u;
    public UserIsBanned(User u)
        {
            super();
            this.u = u;
        }
    public User getU()
    {
        return u;
    }
}
