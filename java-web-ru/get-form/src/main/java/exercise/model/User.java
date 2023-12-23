package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@ToString
public final class User implements Comparable<User> {

    private long id;
    private String firstName;

    @ToString.Include
    private String lastName;

    private String email;

    public User(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public int compareTo(@NotNull User second) {
        return this.firstName.compareTo(second.firstName);
    }
}
