package ru.vote.testtask;


import ru.vote.testtask.model.Role;
import ru.vote.testtask.model.User;

import java.util.Arrays;
import java.util.List;

public class UserTestData {
    public static final User USER = new User(100000, "User", "user@yandex.ru", "password", Role.USER);
    public static final User ADMIN = new User(100001, "Admin", "admin@gmail.com", "admin", Role.ADMIN);

    public static final List<User> USERS = Arrays.asList(USER, ADMIN);
    public static final User[] USERS_ARRAY = {USER, ADMIN};

    public static User getNew() {
        return new User(null, "New user", "password","new_user@rambler.ru",  Role.USER);
    }

    public static User getUpdated() {
        return new User(USER.getId(), "Updated user","updated","user@yandex.ru", Role.USER);
    }


}
