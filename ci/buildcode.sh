#!/bin/sh

cd git-repo
mvn clean package
cp target/pws-spring-boot-demo*.jar ../artifacts/