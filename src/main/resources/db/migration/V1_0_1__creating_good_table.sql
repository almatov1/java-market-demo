CREATE TABLE good
(
    id         UUID DEFAULT uuid_generate_v4(),
    name       VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP,
    PRIMARY KEY (id)
);