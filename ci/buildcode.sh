#!/bin/sh

cd git-repo
mvn clean package
mkdir ../artifacts/
chmod 755 ../artifacts/
cp -p target/pws-spring-boot-demo*.jar ../artifacts/