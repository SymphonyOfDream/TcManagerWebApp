USE tcmanager;


INSERT INTO roles
(role_id, name_tx, description_tx)
VALUES
  (1, 'Admin', 'System administrator')
, (2, 'Mgr', 'Manager of Transaction Coordinators')
, (3, 'User', 'Normal user privileges')
;


INSERT INTO property_types
(property_type_id, name_tx, sort_order_n)
VALUES
  (1, 'Agricultural', 3)
, (2, 'Commercial', 1)
, (3, 'Industrial', 2)
, (4, 'Mixed Use', 4)
, (5, 'Residential', 0)
, (6, 'Special Use', 5)
;


INSERT INTO listing_statuses
(listing_status_id, name_tx, sort_order_n)
VALUES
  (1, 'Active', 2)
, (2, 'Contingent', 3)
, (3, 'Inactive', 1)
, (4, 'Not Started', 0)
, (5, 'Pending', 4)
, (6, 'Sold', 4)
;


INSERT INTO document_compliance_statuses
(document_compliance_status_id, name_tx, sort_order_n)
VALUES
  (1, 'Approved', 3)
, (2, 'Incomplete', 1)
, (3, 'Not Started', 0)
, (4, 'Submitted', 2)
;


INSERT INTO data_input_statuses
(data_input_status_id, name_tx, sort_order_n)
VALUES
  (1, 'Agent Review', 2)
, (2, 'Complete', 3)
, (3, 'Incomplete', 1)
, (4, 'Not Started', 0)
;


INSERT INTO states
(state_id, name_tx)
VALUES
  ('AL', 'Alabama')
, ('AK', 'Alaska')
, ('AS', 'American Samoa')
, ('AZ', 'Arizona')
, ('AR', 'Arkansas')
, ('CA', 'California')
, ('CO', 'Colorado')
, ('CT', 'Connecticut')
, ('DE', 'Delaware')
, ('DC', 'District of Columbia')
, ('FM', 'Federated States of Micronesia')
, ('FL', 'Florida')
, ('GA', 'Georgia')
, ('GU', 'Guam')
, ('HI', 'Hawaii')
, ('ID', 'Idaho')
, ('IL', 'Illinois')
, ('IN', 'Indiana')
, ('IA', 'Iowa')
, ('KS', 'Kansas')
, ('KY', 'Kentucky')
, ('LA', 'Louisiana')
, ('ME', 'Maine')
, ('MD', 'Maryland')
, ('MA', 'Massachusetts')
, ('MH', 'Marshall Islands')
, ('MI', 'Michigan')
, ('MN', 'Minnesota')
, ('MS', 'Mississippi')
, ('MO', 'Missouri')
, ('MP', 'Northern Mariana Islands')
, ('MT', 'Montana')
, ('NE', 'Nebraska')
, ('NV', 'Nevada')
, ('NH', 'New Hampshire')
, ('NJ', 'New Jersey')
, ('NM', 'New Mexico')
, ('NY', 'New York')
, ('NC', 'North Carolina')
, ('ND', 'North Dakota')
, ('OH', 'Ohio')
, ('OK', 'Oklahoma')
, ('OR', 'Oregon')
, ('PA', 'Pennsylvania')
, ('PR', 'Puerto Rico')
, ('PW', 'Palau')
, ('RI', 'Rhode Island')
, ('SC', 'South Carolina')
, ('SD', 'South Dakota')
, ('TN', 'Tennessee')
, ('TX', 'Texas')
, ('UT', 'Utah')
, ('VT', 'Vermont')
, ('VA', 'Virginia')
, ('VI', 'Virgin Islands')
, ('WA', 'Washington')
, ('WV', 'West Virginia')
, ('WI', 'Wisconsin')
, ('WY', 'Wyoming')
;

