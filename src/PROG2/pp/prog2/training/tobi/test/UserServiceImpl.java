package pp.prog2.exercises.test;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Paulina Pyczot
 * @date 22.06.2023
 **/

public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        final Optional<User> user = fetchUser();
        if (user.isEmpty()) return null;
        else return user.get();
    }

    private Optional<User> fetchUser() {
        return Optional.of(new User(UUID.randomUUID().toString()));
    }
}
