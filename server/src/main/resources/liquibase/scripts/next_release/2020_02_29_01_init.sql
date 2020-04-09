-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_02_29_diff.xml
-- Ran at: 2/29/20 2:39 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Create Database Lock Table
CREATE TABLE databasechangeloglock (ID INT NOT NULL, LOCKED BOOLEAN NOT NULL, LOCKGRANTED TIMESTAMP WITHOUT TIME ZONE, LOCKEDBY VARCHAR(255), CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

-- Initialize Database Lock Table
DELETE FROM databasechangeloglock;

INSERT INTO databasechangeloglock (ID, LOCKED) VALUES (1, FALSE);

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = 'Storrund (192.168.56.1)', LOCKGRANTED = '2020-02-29 14:39:00.194' WHERE ID = 1 AND LOCKED = FALSE;

-- Create Database Change Log Table
CREATE TABLE databasechangelog (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP WITHOUT TIME ZONE NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20), CONTEXTS VARCHAR(255), LABELS VARCHAR(255), DEPLOYMENT_ID VARCHAR(10));

-- Changeset 2020_02_29_diff.xml::1582979935597-1::Storrund (generated)
CREATE TABLE authority (id BIGSERIAL NOT NULL, name VARCHAR(255), CONSTRAINT AUTHORITYPK PRIMARY KEY (id));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1582979935597-1', 'Storrund (generated)', '2020_02_29_diff.xml', NOW(), 1, '7:4b49e4f6042dafae1974113dceed434c', 'createTable tableName=AUTHORITY', '', 'EXECUTED', NULL, NULL, '3.5.4', '2979941035');

-- Changeset 2020_02_29_diff.xml::1582979935597-2::Storrund (generated)
CREATE TABLE custom_user (id BIGSERIAL NOT NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(255), username VARCHAR(255), CONSTRAINT USERPK PRIMARY KEY (id));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1582979935597-2', 'Storrund (generated)', '2020_02_29_diff.xml', NOW(), 2, '7:d5d6695adaf3553c8afda2a620aed30c', 'createTable tableName=USER', '', 'EXECUTED', NULL, NULL, '3.5.4', '2979941035');

-- Changeset 2020_02_29_diff.xml::1582979935597-3::Storrund (generated)
CREATE TABLE user_authority (user_id BIGINT NOT NULL, authority_id BIGINT NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1582979935597-3', 'Storrund (generated)', '2020_02_29_diff.xml', NOW(), 3, '7:1d1cb7f181fb12cc5ce2f456a70e00d4', 'createTable tableName=user_authority', '', 'EXECUTED', NULL, NULL, '3.5.4', '2979941035');

-- Changeset 2020_02_29_diff.xml::1582979935597-4::Storrund (generated)
ALTER TABLE user_authority ADD CONSTRAINT "FKe7gyved2c7d6wal4v98q0c9kd" FOREIGN KEY (user_id) REFERENCES custom_user (id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1582979935597-4', 'Storrund (generated)', '2020_02_29_diff.xml', NOW(), 4, '7:d0575aab9546efb84c86c0bfdde4494a', 'addForeignKeyConstraint baseTableName=user_authority, constraintName=FKe7gyved2c7d6wal4v98q0c9kd, referencedTableName=USER', '', 'EXECUTED', NULL, NULL, '3.5.4', '2979941035');

-- Changeset 2020_02_29_diff.xml::1582979935597-5::Storrund (generated)
ALTER TABLE user_authority ADD CONSTRAINT "FKmm9i4h2sem3e4ren6htvhfjmc" FOREIGN KEY (authority_id) REFERENCES AUTHORITY (id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1582979935597-5', 'Storrund (generated)', '2020_02_29_diff.xml', NOW(), 5, '7:abd07649ed47b4cba941b6f888be324b', 'addForeignKeyConstraint baseTableName=user_authority, constraintName=FKmm9i4h2sem3e4ren6htvhfjmc, referencedTableName=AUTHORITY', '', 'EXECUTED', NULL, NULL, '3.5.4', '2979941035');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

