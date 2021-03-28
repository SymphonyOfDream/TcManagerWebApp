USE tcmanager;


CREATE OR REPLACE
VIEW v_users AS
  SELECT	u.user_id AS person_id,
          u.user_name_tx,
          u.account_locked_cd,
          u.user_creation_dt,
          p.first_name_tx,
          p.last_name_tx,
          p.middle_initial_tx,
          p.email_tx,
          p.phone_tx,
          p.is_phone_cell_cd,
          p.person_creation_dt,

          a.street1_tx,
          a.street2_tx,
          a.city_tx,
          a.state_id,
          a.zip_tx
  FROM Users AS u
    JOIN People p ON p.person_id = u.user_id
    LEFT JOIN Addresses a ON a.address_id = p.address_id
;
