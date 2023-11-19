package exercise.dto.users;

import exercise.model.User;
import java.util.List;

// BEGIN
public class UsersPage {
    private List<User> users;
    private String header;

    public String getHeader() {
        return header;
    }

    public UsersPage(List<User> Users, String header) {
        this.users = Users;
        this.header = header;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
// END
