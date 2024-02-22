package Amalitek.amalitek.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
private  final  UserRepository ur;
    @Override
    public List<User> allUsers() {
       try{
           return ur.findAll();
       }catch (Exception ex){

           return null;
       }
    }

    @Override
    public Optional<User> FindUserById(User user) {
        return ur.findById(user.getId());
    }

    @Override
    public User EditUser(User u) {
        return null;
    }
}
