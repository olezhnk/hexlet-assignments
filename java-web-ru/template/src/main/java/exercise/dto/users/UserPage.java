package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UserPage {
    private User user;
    private String header;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHeader() {
        return header;
    }

    public UserPage(User user, String header) {
        this.user = user;
        this.header = header;
    }

}
// END
