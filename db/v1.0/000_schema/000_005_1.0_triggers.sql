USE tcmanager;


#---------------------------------------------------------------------------
# Addresses needs to have at least one pertinent column not null.
#---------------------------------------------------------------------------
CREATE TRIGGER tgr_addresses_insert
    BEFORE INSERT
    ON addresses
    FOR EACH ROW
BEGIN
    IF     NEW.street1_tx IS NULL
       AND NEW.street2_tx IS NULL
       AND NEW.city_tx IS NULL
       AND NEW.state_id IS NULL
       AND NEW.zip_tx IS NULL
    THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Must have at least one of the following columns not null: street1, street2, city, state, zip.';
    END IF;
END;


