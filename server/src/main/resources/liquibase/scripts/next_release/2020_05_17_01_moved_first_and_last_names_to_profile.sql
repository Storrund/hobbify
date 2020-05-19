-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_17_diff.xml
-- Ran at: 5/17/20, 9:12 AM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-101.rdsnet.ro (192.168.0.101)', LOCKGRANTED = '2020-05-17 09:12:44.620' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_17_diff.xml::1589695957154-1::andrei (generated)
ALTER TABLE profile ADD first_name VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589695957154-1', 'andrei (generated)', '2020_05_17_diff.xml', NOW(), 59, '7:3a0d080682556ce8854b627ed56ca8ce', 'addColumn tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9695966338');

-- Changeset 2020_05_17_diff.xml::1589695957154-2::andrei (generated)
ALTER TABLE profile ADD last_name VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589695957154-2', 'andrei (generated)', '2020_05_17_diff.xml', NOW(), 60, '7:8e36a64261a785c854ff0b21a077c48e', 'addColumn tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9695966338');

-- Changeset 2020_05_17_diff.xml::1589695957154-3::andrei (generated)
ALTER TABLE custom_user DROP COLUMN firstname;

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589695957154-3', 'andrei (generated)', '2020_05_17_diff.xml', NOW(), 61, '7:d68b4b954d697878a40fc67e36ca6471', 'dropColumn columnName=firstname, tableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '9695966338');

-- Changeset 2020_05_17_diff.xml::1589695957154-4::andrei (generated)
ALTER TABLE custom_user DROP COLUMN lastname;

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589695957154-4', 'andrei (generated)', '2020_05_17_diff.xml', NOW(), 62, '7:805578ba63feae3cdcf32bf7cf8b5390', 'dropColumn columnName=lastname, tableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '9695966338');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

