CREATE TABLE users
(
    id              UUID         NOT NULL,
    first_name      VARCHAR(255) NOT NULL,
    middle_name     VARCHAR(255),
    last_name       VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    password        VARCHAR(255) NOT NULL,
    items_soled     INTEGER,
    items_bought    INTEGER,
    total_rewarded  INTEGER,
    wallet_balance  DOUBLE PRECISION,
    address         VARCHAR(255),
    country         VARCHAR(255),
    state           VARCHAR(255),
    city            VARCHAR(255),
    pin_code        VARCHAR(255),
    phone_number    VARCHAR(255),
    profile_pic_url VARCHAR(255),
    is_verified     BOOLEAN,
    is_admin        BOOLEAN DEFAULT FALSE,
    creation_time   TIMESTAMP WITHOUT TIME ZONE,
    last_modified   TIMESTAMP WITHOUT TIME ZONE,
    last_active_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_phone_number UNIQUE (phone_number);