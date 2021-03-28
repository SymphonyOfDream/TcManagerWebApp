DROP DATABASE IF EXISTS tcmanager;

CREATE DATABASE tcmanager;

USE tcmanager;

# Setup the DB user the web application will use
DROP USER IF EXISTS tcmanagerapp_user@localhost;
CREATE USER tcmanagerapp_user@localhost IDENTIFIED BY 'je(*g3e4jDL34';
GRANT ALL PRIVILEGES ON tcmanager.* TO tcmanagerapp_user@localhost;


CREATE TABLE states
(
  state_id   CHAR(2)   PRIMARY KEY,

  name_tx   VARCHAR(50)   NOT NULL,

  CONSTRAINT unq_states__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE addresses
(
  address_id   INT   PRIMARY KEY   AUTO_INCREMENT,

  street1_tx        VARCHAR(128)   NULL,
  street2_tx        VARCHAR(128)   NULL,
  city_tx           VARCHAR(128)   NULL,
  state_id          CHAR(2)        NOT NULL,
  zip_tx            VARCHAR(10)    NULL,

  address_creator_user_id   INT            NOT NULL,
  address_creation_dt       DATETIME       NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  INDEX idx_addresses__city_tx (city_tx),
  INDEX idx_addresses__state_id (state_id),
  INDEX idx_addresses__creator_user_id (address_creator_user_id),

  CONSTRAINT fk_addresses___states__state_id
    FOREIGN KEY (state_id) REFERENCES states (state_id)
);


CREATE TABLE people
(
  person_id   INT  PRIMARY KEY   AUTO_INCREMENT,

  first_name_tx       VARCHAR(50)    NULL,
  last_name_tx        VARCHAR(50)    NULL,
  middle_initial_tx   CHAR           NULL,
  email_tx            VARCHAR(128)   NULL,
  phone_tx            VARCHAR(13)    NULL,
  is_phone_cell_cd    BIT            NULL,
  address_id          INT            NULL,

  person_creator_user_id     INT            NOT NULL,
  person_creation_dt         DATETIME       NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  INDEX idx_people__first_name_tx (first_name_tx),
  INDEX idx_people__last_name_tx (last_name_tx),
  INDEX idx_people__creator_user_id (person_creator_user_id),

  CONSTRAINT fk_people__addresses__address_id
    FOREIGN KEY (address_id) REFERENCES addresses (address_id)
);


CREATE TABLE users
(
  user_id   INT  PRIMARY KEY,

  user_name_tx              VARCHAR(50)    NOT NULL,
  hashed_password_tx        VARCHAR(128)   NOT NULL,
  hashed_password_salt_tx   VARCHAR(128)   NOT NULL,
  account_locked_cd         BIT            NOT NULL   DEFAULT 1,

  user_creation_dt             DATETIME         NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT unq_users__user_name_tx
    UNIQUE (user_name_tx),
  CONSTRAINT fk_users__people__person_id
    FOREIGN KEY (user_id) REFERENCES people (person_id)
);


# ip address column large enough to handle IPV6 addresses, just in case.
CREATE TABLE users_login_attempts
(
  user_name_typed_tx   VARCHAR(50)    NOT NULL,
  ip_address_tx        VARCHAR(39)    NOT NULL,
  successful_cd        BIT            NOT NULL,
  login_attempt_creation_dt   DATETIME       NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  INDEX idx_users_login_attempts__user_name_typed_tx (user_name_typed_tx),
  INDEX idx_users_login_attempts__ip_address_tx (ip_address_tx)
);

CREATE TABLE roles
(
  role_id   INT   PRIMARY KEY,

  name_tx          VARCHAR(25)   NOT NULL,
  description_tx   VARCHAR(75)   NULL,

  CONSTRAINT unq_roles__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE users_roles
(
  user_id   INT   NOT NULL,
  role_id   INT   NOT NULL,

  users_role_creator_user_id   INT        NOT NULL,
  users_role_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (user_id, role_id),

  CONSTRAINT fk_users_roles__users__user_id
    FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT fk_users_roles__roles__role_id
    FOREIGN KEY (role_id) REFERENCES roles (role_id),
  CONSTRAINT fk_users_roles__users__creator_user_id
    FOREIGN KEY (users_role_creator_user_id) REFERENCES users (user_id)
);


