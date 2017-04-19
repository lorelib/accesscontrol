@echo off
set localdir=%~dp0

echo start clean

call mvn clean -f dependency\pom.xml
call mvn clean

echo end clean