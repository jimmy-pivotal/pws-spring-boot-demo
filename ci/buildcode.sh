#!/bin/sh

cd git-repo
mvn clean package
cp -p target/pws-spring-boot-demo*.jar ../build-output/