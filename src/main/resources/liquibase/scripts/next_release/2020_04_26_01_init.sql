-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_04_26_diff.xml
-- Ran at: 4/26/20, 9:34 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-111.rdsnet.ro (192.168.0.111)', LOCKGRANTED = '2020-04-26 21:34:51.017' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_04_26_diff.xml::1587926083931-1::andrei (generated)
CREATE TABLE authority (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, name VARCHAR(255));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-1', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 24, '7:17e93005e16afbc63720cb52fd55f40b', 'createTable tableName=authority', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-2::andrei (generated)
CREATE TABLE custom_user (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(255), username VARCHAR(255));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-2', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 25, '7:eabcf34660043cd5154a1bd036f21b01', 'createTable tableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-3::andrei (generated)
CREATE TABLE user_authority (user_uuid VARCHAR(255) NOT NULL, authority_uuid VARCHAR(255) NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-3', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 26, '7:3b46a850f1a73e997138265667d80f6e', 'createTable tableName=user_authority', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-4::andrei (generated)
ALTER TABLE authority ADD CONSTRAINT "authorityPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-4', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 27, '7:f6321570dd52134d41a774fd6a563610', 'addPrimaryKey constraintName=authorityPK, tableName=authority', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-5::andrei (generated)
ALTER TABLE custom_user ADD CONSTRAINT "custom_userPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-5', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 28, '7:90ff60eda6e5fb8b225746af96f061bc', 'addPrimaryKey constraintName=custom_userPK, tableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-6::andrei (generated)
ALTER TABLE user_authority ADD CONSTRAINT "FK54ou31qm4ix4gv64snwohvu1p" FOREIGN KEY (authority_uuid) REFERENCES authority (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-6', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 29, '7:980928e554a41625027d3124d6801bf8', 'addForeignKeyConstraint baseTableName=user_authority, constraintName=FK54ou31qm4ix4gv64snwohvu1p, referencedTableName=authority', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Changeset 2020_04_26_diff.xml::1587926083931-7::andrei (generated)
ALTER TABLE user_authority ADD CONSTRAINT "FKtckuwhtlntkv7fi7n5ljlgdmc" FOREIGN KEY (user_uuid) REFERENCES custom_user (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1587926083931-7', 'andrei (generated)', '2020_04_26_diff.xml', NOW(), 30, '7:99315727be9b7af517a39f767cc736d5', 'addForeignKeyConstraint baseTableName=user_authority, constraintName=FKtckuwhtlntkv7fi7n5ljlgdmc, referencedTableName=custom_user', '', 'EXECUTED', NULL, NULL, '3.5.4', '7926092681');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

