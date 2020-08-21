import java.util.ArrayList;
import java.util.List;

public class Check {

    private static final List<User> store = new ArrayList(){{add(new User("admin","admin", User.ROLE.ADMIN));}};

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return store.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.NONAME;

        for (User user : store) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }
    public void setRoleAdmin(String login) {
        for (User user : store) {
            if (user.getLogin().equals(login)) {
                user.setRole(User.ROLE.ADMIN);
            }
        }
    }
}