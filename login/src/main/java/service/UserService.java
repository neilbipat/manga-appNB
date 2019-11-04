package service;

import com.example.login.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public Iterable<User> listUsers();

    public String createUser (User newUser);

    public String login(User user);

    public User getUser (String username);

}
