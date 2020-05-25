-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_13_diff.xml
-- Ran at: 5/13/20, 9:14 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-110.rdsnet.ro (192.168.0.110)', LOCKGRANTED = '2020-05-13 21:14:11.935' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_13_diff.xml::1589393643953-1::andrei (generated)
CREATE TABLE post (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, content VARCHAR(500), post_date TIMESTAMP WITHOUT TIME ZONE, custom_user_uuid VARCHAR(255), hobby_uuid VARCHAR(255));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589393643953-1', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 46, '7:bd57b973529ae1cd9eb052cc99843db1', 'createTable tableName=post', '', 'EXECUTED', NULL, NULL, '3.5.4', '9393653618');

-- Changeset 2020_05_13_diff.xml::1589393643953-2::andrei (generated)
ALTER TABLE post ADD CONSTRAINT "postPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589393643953-2', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 47, '7:ce3b6338bd00bce0a8f6d61d375eae05', 'addPrimaryKey constraintName=postPK, tableName=post', '', 'EXECUTED', NULL, NULL, '3.5.4', '9393653618');

-- Changeset 2020_05_13_diff.xml::1589393643953-3::andrei (generated)
ALTER TABLE post ADD CONSTRAINT FK_POST__CUSTOM_USER FOREIGN KEY (custom_user_uuid) REFERENCES custom_user (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589393643953-3', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 48, '7:ba4465d8ce23a157a5669a013eb540c1', 'addForeignKeyConstraint baseTableName=post, constraintName=FK_POST__CUSTOM_USER, referencedTableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '9393653618');

-- Changeset 2020_05_13_diff.xml::1589393643953-4::andrei (generated)
ALTER TABLE post ADD CONSTRAINT FK_POST__HOBBY FOREIGN KEY (hobby_uuid) REFERENCES hobby (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589393643953-4', 'andrei (generated)', '2020_05_13_diff.xml', NOW(), 49, '7:f2671c59f99ae35f90b996b265c64ae8', 'addForeignKeyConstraint baseTableName=post, constraintName=FK_POST__HOBBY, referencedTableName=hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '9393653618');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

