CREATE TABLE IF NOT EXISTS People (
    id          UUID            PRIMARY KEY,
    lastname    VARCHAR(50)     NOT NULL,
    firstname   VARCHAR(50)     NOT NULL
);

CREATE TABLE IF NOT EXISTS Users (
    id                  UUID            PRIMARY KEY,
    lastname            VARCHAR(50)     NOT NULL,
    firstname           VARCHAR(50)     NOT NULL,
    email               VARCHAR(50)     NOT NULL,
    password            VARCHAR(255)    NOT NULL,
    date_of_birthday    DATE            NOT NULL
);

CREATE TABLE IF NOT EXISTS Events_Statuses (
    id              UUID            PRIMARY KEY,
    name            VARCHAR(50)     NOT NULL,
    description     TEXT
);

CREATE TABLE IF NOT EXISTS Events (
    id              UUID            PRIMARY KEY,
    name            VARCHAR(50)     NOT NULL,
    description     TEXT,
    date            DATE            NOT NULL,
    type_id         UUID            NOT NULL        REFERENCES Events_Statuses(id),
    person_id         UUID            REFERENCES People(id)
);

CREATE TABLE IF NOT EXISTS Subscriptions (
    id          UUID    PRIMARY KEY,
    user_id     UUID    NOT NULL        REFERENCES Users(id),
    event_id    UUID    NOT NULL        REFERENCES Events(id)
)