-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_17_diff.xml
-- Ran at: 5/17/20, 11:23 AM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-101.rdsnet.ro (192.168.0.101)', LOCKGRANTED = '2020-05-17 11:23:57.394' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_17_diff.xml::1589703826683-1::andrei (generated)
ALTER TABLE profile ADD description VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589703826683-1', 'andrei (generated)', '2020_05_17_diff.xml', NOW(), 63, '7:e2d7aa755db03b75c5309e0ad6d54220', 'addColumn tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9703839375');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

