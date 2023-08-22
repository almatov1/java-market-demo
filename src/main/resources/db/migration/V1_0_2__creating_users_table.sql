CREATE TABLE users
(
    id         UUID DEFAULT uuid_generate_v4(),
    mail       VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP,
    PRIMARY KEY (id)
);