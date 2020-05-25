-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_13_diff.xml
-- Ran at: 5/13/20, 9:22 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-110.rdsnet.ro (192.168.0.110)', LOCKGRANTED = '2020-05-13 21:22:50.177' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_13_diff.xml::1589394162507-1::andrei (generated)
ALTER TABLE post ADD profile_uuid VARCHAR(255);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589394162507-1', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 50, '7:4f079e40e6908f130660b88241185f38', 'addColumn tableName=post', '', 'EXECUTED', NULL, NULL, '3.5.4', '9394171939');

-- Changeset 2020_05_13_diff.xml::1589394162507-2::andrei (generated)
ALTER TABLE post ADD CONSTRAINT FK_POST__PROFILE FOREIGN KEY (profile_uuid) REFERENCES profile (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589394162507-2', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 51, '7:ef4bc656edb9aeae03d5d633c117c75b', 'addForeignKeyConstraint baseTableName=post, constraintName=FK_POST__PROFILE, referencedTableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9394171939');

-- Changeset 2020_05_13_diff.xml::1589394162507-3::andrei (generated)
ALTER TABLE post DROP CONSTRAINT fk_post__custom_user;

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589394162507-3', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 52, '7:e7c54daef7e2e797258a56bfab09d873', 'dropForeignKeyConstraint baseTableName=post, constraintName=fk_post__custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '9394171939');

-- Changeset 2020_05_13_diff.xml::1589394162507-4::andrei (generated)
ALTER TABLE post DROP COLUMN custom_user_uuid;

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589394162507-4', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 53, '7:a676f43d59581b982ae8f37be1b21912', 'dropColumn columnName=custom_user_uuid, tableName=post', '', 'EXECUTED', NULL, NULL, '3.5.4', '9394171939');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

