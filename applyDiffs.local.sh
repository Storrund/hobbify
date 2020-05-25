#!/usr/bin/env bash

mvn clean install -DskipTests -T 4;
mvn liquibase:update -Dliquibase.propertyFile=src/main/resources/liquibase/liquibase_local.properties