DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM restaurants;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

-- INSERT INTO user_roles (user_id, role)
-- VALUES (0, 'USER'),
--        (1, 'ADMIN');

INSERT INTO restaurants(name, description)
VALUES ('first restaurant', 'fi re desc'),
       ('sec restaurant', 'se re desc');

INSERT INTO meals (name, price, restaurant_id)
VALUES ('meal 1 re 1', 100, 0),
       ('meal 2 re 1', 200, 0),
       ('meal 1 re 2', 300, 1),
       ('meal 2 re 2', 400, 1);