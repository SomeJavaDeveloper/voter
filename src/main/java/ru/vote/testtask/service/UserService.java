package ru.vote.testtask.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vote.testtask.AuthorizedUser;
import ru.vote.testtask.model.User;
import ru.vote.testtask.repository.UserRepository;

import java.util.List;

import static ru.vote.testtask.util.UserUtil.prepareToSave;

@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return prepareAndSave(user);
    }


    public User get(int id) {
        return repository.get(id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

//    public void update(User user) {
//        Assert.notNull(user, "user must not be null");
//        prepareAndSave(user);
//    }

//    @Transactional
//    public void update(UserTo userTo) {
//        User user = get(userTo.getId());
//        User updatedUser = UserUtil.updateFromTo(user, userTo);
//        prepareAndSave(updatedUser);
//    }


    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }

    private User prepareAndSave(User user) {
        return repository.save(prepareToSave(user, passwordEncoder));
    }

    public void vote(int userId, int restaurantId) {
        User user = get(userId);
        repository.vote(user, restaurantId);
    }
}
