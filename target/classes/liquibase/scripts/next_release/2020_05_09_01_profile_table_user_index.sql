-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_09_diff.xml
-- Ran at: 5/9/20, 1:02 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-105.rdsnet.ro (192.168.0.105)', LOCKGRANTED = '2020-05-09 13:02:09.052' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_09_diff.xml::1589018521304-1::andrei (generated)
ALTER TABLE profile ADD CONSTRAINT user_uuid_index UNIQUE (custom_user_uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589018521304-1', 'andrei (generated)', '2020_05_09_diff.xml', NOW(), 45, '7:883037c2a58ed586c1464ed96eaf8d4b', 'addUniqueConstraint constraintName=user_uuid_index, tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9018530855');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

