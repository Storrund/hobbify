-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_04_30_diff.xml
-- Ran at: 4/30/20, 5:27 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-111.rdsnet.ro (192.168.0.111)', LOCKGRANTED = '2020-04-30 17:27:54.390' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_04_30_diff.xml::1588256866860-1::andrei (generated)
ALTER TABLE profile ADD custom_user_uuid VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256866860-1', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 41, '7:2af21da91e3aa696fa2ca2c724b19c9f', 'addColumn tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256876037');

-- Changeset 2020_04_30_diff.xml::1588256866860-2::andrei (generated)
ALTER TABLE hobby ADD hobby_category_uuid VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256866860-2', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 42, '7:1e24c0013f39fdc6e4bd8c7844ac9dc5', 'addColumn tableName=hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256876037');

-- Changeset 2020_04_30_diff.xml::1588256866860-3::andrei (generated)
ALTER TABLE hobby ADD CONSTRAINT FK_HOBBY__HOBBY_CATEGORY FOREIGN KEY (hobby_category_uuid) REFERENCES hobby_category (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256866860-3', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 43, '7:7ffbb6fe562b44ac61035ed961ad90df', 'addForeignKeyConstraint baseTableName=hobby, constraintName=FK_HOBBY__HOBBY_CATEGORY, referencedTableName=hobby_category', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256876037');

-- Changeset 2020_04_30_diff.xml::1588256866860-4::andrei (generated)
ALTER TABLE profile ADD CONSTRAINT FK_PROFILE__CUSTOM_USER FOREIGN KEY (custom_user_uuid) REFERENCES custom_user (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256866860-4', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 44, '7:a4cc4c0f559b3e2f1f68c343ba2d75db', 'addForeignKeyConstraint baseTableName=profile, constraintName=FK_PROFILE__CUSTOM_USER, referencedTableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256876037');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

