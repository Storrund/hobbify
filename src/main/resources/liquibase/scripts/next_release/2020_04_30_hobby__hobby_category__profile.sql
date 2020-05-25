-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: 2020_04_30_diff.xml
-- Ran at: 4/30/20, 5:13 PM
-- Against: hobbify@jdbc:postgresql://localhost:5432/hobbify_master
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '192-168-0-111.rdsnet.ro (192.168.0.111)', LOCKGRANTED = '2020-04-30 17:13:38.773' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset 2020_04_30_diff.xml::1588256011978-1::andrei (generated)
CREATE TABLE hobby (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, icon_tag VARCHAR(255) NOT NULL, name VARCHAR(255) NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-1', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 31, '7:c846cf1b122a8417f4e0b87ef4ffa15d', 'createTable tableName=hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-2::andrei (generated)
CREATE TABLE hobby_category (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL, color VARCHAR(255) NOT NULL, name VARCHAR(255) NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-2', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 32, '7:751b34fa6873e2b7de5c87d40e902534', 'createTable tableName=hobby_category', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-3::andrei (generated)
CREATE TABLE profile (uuid VARCHAR(255) NOT NULL, created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL, version BIGINT NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-3', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 33, '7:a44fd3d50ab01d2d7e76dd6c43128ab7', 'createTable tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-4::andrei (generated)
CREATE TABLE profile_hobby (profile_uuid VARCHAR(255) NOT NULL, hobby_uuid VARCHAR(255) NOT NULL);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-4', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 34, '7:ae6a4cc6cf40a10661839a77f9f0345b', 'createTable tableName=profile_hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-5::andrei (generated)
ALTER TABLE profile_hobby ADD PRIMARY KEY (profile_uuid, hobby_uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-5', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 35, '7:9c2a2a502bb66707ec77e990485816ff', 'addPrimaryKey tableName=profile_hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-6::andrei (generated)
ALTER TABLE hobby ADD CONSTRAINT "hobbyPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-6', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 36, '7:0265693877bcec459408f94ae6697c24', 'addPrimaryKey constraintName=hobbyPK, tableName=hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-7::andrei (generated)
ALTER TABLE hobby_category ADD CONSTRAINT "hobby_categoryPK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-7', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 37, '7:afa41841a39553b4e06de1d1800660bc', 'addPrimaryKey constraintName=hobby_categoryPK, tableName=hobby_category', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-8::andrei (generated)
ALTER TABLE profile ADD CONSTRAINT "profilePK" PRIMARY KEY (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-8', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 38, '7:f7bd345ec2536248e257d152920a294d', 'addPrimaryKey constraintName=profilePK, tableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-9::andrei (generated)
ALTER TABLE profile_hobby ADD CONSTRAINT "FK83x71m618u3341nljnxmg1q1j" FOREIGN KEY (profile_uuid) REFERENCES profile (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-9', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 39, '7:b770dab31ea70686ffd1ce0c126a61e5', 'addForeignKeyConstraint baseTableName=profile_hobby, constraintName=FK83x71m618u3341nljnxmg1q1j, referencedTableName=profile', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Changeset 2020_04_30_diff.xml::1588256011978-10::andrei (generated)
ALTER TABLE profile_hobby ADD CONSTRAINT "FKdxmplckuqs2fskebb9kgywex8" FOREIGN KEY (hobby_uuid) REFERENCES hobby (uuid);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1588256011978-10', 'andrei (generated)', '2020_04_30_diff.xml', NOW(), 40, '7:b097f840027bff5d8e2b01113bd738c8', 'addForeignKeyConstraint baseTableName=profile_hobby, constraintName=FKdxmplckuqs2fskebb9kgywex8, referencedTableName=hobby', '', 'EXECUTED', NULL, NULL, '3.5.4', '8256020320');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

