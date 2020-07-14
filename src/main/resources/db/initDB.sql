DROP TABLE user_roles IF EXISTS;
DROP TABLE meals IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE restaurants IF EXISTS;

CREATE TABLE restaurants
(
    id               INTEGER IDENTITY PRIMARY KEY,
    name             VARCHAR(255)            NOT NULL,
    description VARCHAR(255)                 NOT NULL
);

CREATE TABLE users
(
    id               INTEGER IDENTITY PRIMARY KEY,
    name             VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            NOT NULL,
    password         VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL,
    enabled          BOOLEAN   DEFAULT TRUE  NOT NULL,
    restaurant_id    INTEGER
);
-- CREATE UNIQUE INDEX users_unique_email_idx
--     ON USERS (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE meals
(
    id                INTEGER IDENTITY PRIMARY KEY,
    name              VARCHAR(255)            NOT NULL,
    price             INTEGER      NOT NULL,
    restaurant_id     INTEGER      NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
-- CREATE UNIQUE INDEX meals_unique_user_idx
--     ON meals (restaurant_id)