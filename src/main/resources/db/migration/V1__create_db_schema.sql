CREATE TABLE IF NOT EXISTS People (
    id          UUID            PRIMARY KEY,
    lastname    VARCHAR(50)     NOT NULL,
    firstname   VARCHAR(50)     NOT NULL,
    middle_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Users (
    id                  UUID            PRIMARY KEY,
    lastname            VARCHAR(50)     NOT NULL,
    firstname           VARCHAR(50)     NOT NULL,
    email               VARCHAR(50)     NOT NULL        UNIQUE,
    password            VARCHAR(255)    NOT NULL,
    date_of_birthday    DATE            NOT NULL
);

CREATE TABLE IF NOT EXISTS Events (
    id              UUID            PRIMARY KEY,
    name            VARCHAR(50)     NOT NULL,
    description     TEXT,
    date            DATE            NOT NULL,
    type            VARCHAR(50)     NOT NULL,
    person_id       UUID            REFERENCES People(id)
);

CREATE TABLE IF NOT EXISTS Subscriptions (
    user_id     UUID    NOT NULL        REFERENCES Users(id) ON DELETE CASCADE,
    event_id    UUID    NOT NULL        REFERENCES Events(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, event_id)
)