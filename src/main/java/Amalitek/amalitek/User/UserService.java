package Amalitek.amalitek.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> allUsers();
    public Optional<User>FindUserById(User user);

    public User EditUser(User user);
}
