-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_05_16_diff.xml
-- Ran at: 5/16/20, 1:51 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-101.rdsnet.ro (192.168.0.101)', LOCKGRANTED = '2020-05-16 13:51:47.887' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_05_16_diff.xml::1589626298146-1::andrei (generated)
CREATE TABLE profile_friend (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, accepted BOOLEAN NOT NULL, first_profile_uuid VARCHAR(255), second_profile_uuid VARCHAR(255));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589626298146-1', 'andrei (generated)', '2020_05_16_diff.xml', NOW(), 54, '7:d0840592c76c9645ed7f289211141d4c', 'createTable tableName=profile_friend', '', 'EXECUTED', NULL, NULL, '3.5.4', '9626310185');

-- Changeset 2020_05_16_diff.xml::1589626298146-2::andrei (generated)
ALTER TABLE profile_friend ADD CONSTRAINT "profile_friendPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589626298146-2', 'andrei (generated)', '2020_05_16_diff.xml', NOW(), 55, '7:2a01e8dc035c8514e9726ce969db3185', 'addPrimaryKey constraintName=profile_friendPK, tableName=profile_friend', '', 'EXECUTED', NULL, NULL, '3.5.4', '9626310185');

-- Changeset 2020_05_16_diff.xml::1589626298146-3::andrei (generated)
ALTER TABLE profile_friend ADD CONSTRAINT profile_uuid_index UNIQUE (first_profile_uuid, second_profile_uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589626298146-3', 'andrei (generated)', '2020_05_16_diff.xml', NOW(), 56, '7:c4da0834f4f8b560d2c1155092b7eb48', 'addUniqueConstraint constraintName=profile_uuid_index, tableName=profile_friend', '', 'EXECUTED', NULL, NULL, '3.5.4', '9626310185');

-- Changeset 2020_05_16_diff.xml::1589626298146-4::andrei (generated)
ALTER TABLE profile_friend ADD CONSTRAINT FK_PROFILE_FRIEND__PROFILE_FIRST FOREIGN KEY (first_profile_uuid) REFERENCES profile (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589626298146-4', 'andrei (generated)', '2020_05_16_diff.xml', NOW(), 57, '7:228659be6336087a7d7e2d62c467b457', 'addForeignKeyConstraint baseTableName=profile_friend, constraintName=FK_PROFILE_FRIEND__PROFILE_FIRST, referencedTableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9626310185');

-- Changeset 2020_05_16_diff.xml::1589626298146-5::andrei (generated)
ALTER TABLE profile_friend ADD CONSTRAINT FK_PROFILE_FRIEND__PROFILE_SECOND FOREIGN KEY (second_profile_uuid) REFERENCES profile (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1589626298146-5', 'andrei (generated)', '2020_05_16_diff.xml', NOW(), 58, '7:efb68986aef8dfa72c72e8854eb90407', 'addForeignKeyConstraint baseTableName=profile_friend, constraintName=FK_PROFILE_FRIEND__PROFILE_SECOND, referencedTableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '9626310185');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

