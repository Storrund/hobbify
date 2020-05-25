#!/usr/bin/env bash

now=$(date +"%Y_%m_%d")
fileName=${now}_diff
propertyFile=src/main/resources/liquibase/liquibase_local.properties
export outputFile=src/main/resources/liquibase/scripts/next_release/${fileName}.sql

mvn clean install -DskipTests -T 4;

#generates changelog.xml file
mvn -Dliquibase.propertyFile=${propertyFile} \
    -Dliquibase.diffChangeLogFile=./${fileName}.xml \
    liquibase:diff


#generates final changelog.sql file
mvn -Dliquibase.propertyFile=${propertyFile} \
    -Dliquibase.changeLogFile=${fileName}.xml \
    -Dliquibase.migrationSqlOutputFile=${outputFile} \
    liquibase:updateSQL

echo "Created file: "${outputFile}
#remove unused xml file
rm ./${fileName}.xml