#!/bin/sh

cd git-repo
mvn clean package
cp target/*.jar ../artifacts/