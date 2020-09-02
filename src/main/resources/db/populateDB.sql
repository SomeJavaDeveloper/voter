DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
DELETE FROM restaurants;

INSERT INTO users (name, email, password, restaurant_id)
VALUES ('User', 'user@yandex.ru', '{noop}password', 100000),
       ('Admin', 'admin@gmail.com', '{noop}admin', 100001);

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants(name, description)
VALUES ('first restaurant', 'fi re desc'),
       ('sec restaurant', 'se re desc');

INSERT INTO meals (name, price, restaurant_id)
VALUES ('meal 1 re 1', 100, 100000),
       ('meal 2 re 1', 200, 100000),
       ('meal 1 re 2', 300, 100001),
       ('meal 2 re 2', 400, 100001);