USE tcmanager;


CREATE TABLE brokerages
(
  brokerage_id   INT   PRIMARY KEY   AUTO_INCREMENT,

  name_tx           VARCHAR(75)   NOT NULL,
  broker_id         INT           NOT NULL,

  brokerage_creator_user_id   INT           NOT NULL,
  brokerage_creation_dt       DATETIME      NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  INDEX idx_brokerages__name_tx (name_tx),

  CONSTRAINT fk_brokerages__people__state_id
    FOREIGN KEY (broker_id) REFERENCES people (person_id),
  CONSTRAINT fk_brokerages__users__creator_user_id
    FOREIGN KEY (brokerage_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE realtors
(
  realtor_id   INT   PRIMARY KEY,

  is_broker_cd      BIT        NOT NULL,
  brokerage_id      INT        NOT NULL,

  realtor_creator_user_id   INT        NOT NULL,
  realtor_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_realtors__people__state_id
    FOREIGN KEY (realtor_id) REFERENCES people (person_id),
  CONSTRAINT fk_realtors__brokerages__brokerage_id
    FOREIGN KEY (brokerage_id) REFERENCES brokerages (brokerage_id),
  CONSTRAINT fk_realtors__users__creator_user_id
    FOREIGN KEY (realtor_creator_user_id) REFERENCES users (user_id)

);


CREATE TABLE teams
(
  team_id   INT   PRIMARY KEY   AUTO_INCREMENT,

  name_tx           VARCHAR(75)   NOT NULL,

  team_creator_user_id   INT           NOT NULL,
  team_creation_dt       DATETIME      NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT unq_teams__name_tx
    UNIQUE INDEX (name_tx),
  CONSTRAINT fk_teams__users__creator_user_id
    FOREIGN KEY (team_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE teams_realtors
(
  team_id      INT   NOT NULL,
  realtor_id   INT   NOT NULL,

  teams_realtor_creator_user_id   INT        NOT NULL,
  teams_realtor_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (team_id, realtor_id),

  CONSTRAINT fk_teams_realtors__teams__team_id
    FOREIGN KEY (team_id) REFERENCES teams (team_id),
  CONSTRAINT fk_teams_realtors__people__realtor_id
    FOREIGN KEY (realtor_id) REFERENCES people (person_id),
  CONSTRAINT fk_teams_realtors__users__creator_user_id
    FOREIGN KEY (teams_realtor_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE property_types
(
  property_type_id   TINYINT   PRIMARY KEY,

  name_tx       VARCHAR(20)   NOT NULL,
  sort_order_n  TINYINT       NOT NULL,

  CONSTRAINT unq_property_types__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE listing_statuses
(
  listing_status_id   TINYINT   PRIMARY KEY,

  name_tx       VARCHAR(20)   NOT NULL,
  sort_order_n  TINYINT       NOT NULL,

  CONSTRAINT unq_listing_statuses__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE document_compliance_statuses
(
  document_compliance_status_id   TINYINT   PRIMARY KEY,

  name_tx       VARCHAR(20)   NOT NULL,
  sort_order_n  TINYINT       NOT NULL,

  CONSTRAINT unq_document_compliance_statuses__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE data_input_statuses
(
  data_input_status_id   TINYINT   PRIMARY KEY,

  name_tx       VARCHAR(20)   NOT NULL,
  sort_order_n  TINYINT       NOT NULL,

  CONSTRAINT unq_data_input_statuses__name_tx
    UNIQUE INDEX (name_tx)
);


CREATE TABLE listings
(
  listing_id   INT   PRIMARY KEY   AUTO_INCREMENT,

  address_id                      INT             NOT NULL,
  property_type_id                TINYINT         NOT NULL,
  listing_status_id               TINYINT         NOT NULL,
  document_compliance_status_id   TINYINT         NOT NULL,
  data_input_status_id            TINYINT         NOT NULL,
  price_am                        DECIMAL(15,2)   NOT NULL,

  received_dt                     DATE            NOT NULL,
  list_dt                         DATE            NOT NULL,
  expiration_dt                   DATE            NOT NULL,

  listing_creator_user_id         INT             NOT NULL,
  listing_creation_dt             DATETIME        NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_listings__addresses__address_id
    FOREIGN KEY (address_id) REFERENCES addresses (address_id),
  CONSTRAINT fk_listings__property_types__listing_status_id
    FOREIGN KEY (property_type_id) REFERENCES property_types (property_type_id),
  CONSTRAINT fk_listings__listing_statuses__listing_status_id
    FOREIGN KEY (listing_status_id) REFERENCES listing_statuses (listing_status_id),
  CONSTRAINT fk_listings__doc_comp_statuses__document_compliance_status_id
    FOREIGN KEY (document_compliance_status_id) REFERENCES document_compliance_statuses (document_compliance_status_id),
  CONSTRAINT fk_listings__data_input_statuses__data_input_status_id
    FOREIGN KEY (data_input_status_id) REFERENCES data_input_statuses (data_input_status_id),
  CONSTRAINT fk_listings__users__creator_user_id
    FOREIGN KEY (listing_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE listings_sellers
(
  listing_id   INT   NOT NULL,
  person_id    INT   NOT NULL,

  listings_seller_creator_user_id   INT        NOT NULL,
  listings_seller_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_listings_sellers__listings__listing_id
    FOREIGN KEY (listing_id) REFERENCES listings (listing_id),
  CONSTRAINT fk_listings_sellers__people__person_id
    FOREIGN KEY (person_id) REFERENCES people (person_id),
  CONSTRAINT fk_listings_sellers__creator_user_id
    FOREIGN KEY (listings_seller_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE listings_sellers_agents
(
  listing_id   INT   NOT NULL,
  realtor_id   INT   NOT NULL,

  listings_sellers_agents_creator_user_id   INT        NOT NULL,
  listings_sellers_agents_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_listings_sellers_agents__listings__listing_id
    FOREIGN KEY (listing_id) REFERENCES listings (listing_id),
  CONSTRAINT fk_listings_sellers_agents__realtors__realtor_id
    FOREIGN KEY (realtor_id) REFERENCES realtors (realtor_id),
  CONSTRAINT fk_listings_sellers_agents__creator_user_id
    FOREIGN KEY (listings_sellers_agents_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE listings_buyers
(
  listing_id   INT   NOT NULL,
  realtor_id   INT   NOT NULL,

  listings_buyers_creator_user_id   INT        NOT NULL,
  listings_buyers_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_listings_buyers__listings__listing_id
    FOREIGN KEY (listing_id) REFERENCES listings (listing_id),
  CONSTRAINT fk_listings_buyers__realtors__realtor_id
    FOREIGN KEY (realtor_id) REFERENCES realtors (realtor_id),
  CONSTRAINT fk_listings_buyers__creator_user_id
    FOREIGN KEY (listings_buyers_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE listings_buyers_agents
(
  listing_id   INT   NOT NULL,
  realtor_id   INT   NOT NULL,

  listings_buyers_agents_creator_user_id   INT        NOT NULL,
  listings_buyers_agents_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_listings_buyers_agents__listings__listing_id
    FOREIGN KEY (listing_id) REFERENCES listings (listing_id),
  CONSTRAINT fk_listings_buyers_agents__realtors__realtor_id
    FOREIGN KEY (realtor_id) REFERENCES realtors (realtor_id),
  CONSTRAINT fk_listings_buyers_agents__creator_user_id
    FOREIGN KEY (listings_buyers_agents_creator_user_id) REFERENCES users (user_id)
);


CREATE TABLE listings_notes
(
  listing_note_id   INT   PRIMARY KEY   AUTO_INCREMENT,

  listing_id        INT        NOT NULL,
  note              TEXT       NOT NULL,
  is_public_cd      BIT        NOT NULL   DEFAULT 0,

  listings_notes_creator_user_id   INT        NOT NULL,
  listings_notes_creation_dt       DATETIME   NOT NULL   DEFAULT CURRENT_TIMESTAMP,

  CONSTRAINT fk_lists_notes__listings__listing_id
    FOREIGN KEY (listing_id) REFERENCES listings (listing_id),
  CONSTRAINT fk_lists_notes__creator_user_id
    FOREIGN KEY (listings_notes_creator_user_id) REFERENCES users (user_id)
);


