@echo off
set localdir=%~dp0

echo start build

if "%1" == "c" call clean.cmd

call mvn install -f dependency\pom.xml -Dmaven.test.skip=true
call mvn install -Dmaven.test.skip=true


echo end build
