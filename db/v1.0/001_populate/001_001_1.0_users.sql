USE tcmanager;


INSERT INTO addresses
( street1_tx, street2_tx, city_tx, state_id, zip_tx, address_creator_user_id)
VALUES
('1180 PEEBLES DR', NULL, 'Fairborn', 'WI', 45324, 1)
;

INSERT INTO people
(first_name_tx, last_name_tx, middle_initial_tx, email_tx, phone_tx, is_phone_cell_cd, address_id, person_creator_user_id)
VALUES
  ('David', 'Lowe', NULL, 'dave.lowe@gmail.com',  '937-619-9006', 1, 1, 1)
, ('Amy',   'Lowe', NULL, 'amy.s.lowe@gmail.com', '937-608-9838', 1, 1, 1)
;

INSERT INTO users
(user_id, user_name_tx, hashed_password_tx, hashed_password_salt_tx, account_locked_cd)
VALUES
(
 1,
 'dave',
 'IK14dCYTLtrjt3LUpw3Kk1ILBaQcjTM1iKGUgvXmROydpSlpXILH2xHulPpuFh1ue/EeJkfYJtxrU42snrfFYQ==',
 '277D31E848ED6540A9BC761C30E9D4E4',
  0
)
,
(
 2,
 'amy',
 'EDE12DA3F42A8F0F4CD30D0A7FB710A74F1E10F60765F4F495352836B619821BC832C33CD9F98BCE6D7C97A7D9A8DCC8C37B0F54BC6F2D26AFD5B50FDE371D12',
 '277D31E848ED6540A9BC761C30E9D4E4',
  0
)
;

INSERT INTO users_roles
(user_id, role_id, users_role_creator_user_id)
VALUES
  (1, 1, 1) # dave => Admin
, (2, 2, 1) # amy => Manager
;

