package ru.vote.testtask.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vote.testtask.model.User;
import ru.vote.testtask.service.UserService;
import ru.vote.testtask.to.UserTo;
import ru.vote.testtask.util.UserUtil;

import java.util.List;

public abstract class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        return service.create(user);
    }

    public User create(UserTo userTo) {
        log.info("create from to {}", userTo);
        return create(UserUtil.createNewFromTo(userTo));
    }

//    public void delete(int id) {
//        log.info("delete {}", id);
//        service.delete(id);
//    }

//    public void update(User user, int id) {
//        log.info("update {} with id={}", user, id);
//        service.update(user);
//    }
//
//    public void update(UserTo user, int id) {
//        log.info("update {} with id={}", user, id);
//        service.update(user);
//    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}
