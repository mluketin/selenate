@echo off

echo Publishing Client...
call "%~dp0sbt.bat" --no-jrebel %* Client/clean Client/publish

echo Publishing Common...
call "%~dp0sbt.bat" --no-jrebel %* Common/clean Common/publish

echo Publishing Library...
call "%~dp0sbt.bat" --no-jrebel %* Library/clean Library/publish

echo Publishing Server...
call "%~dp0sbt.bat" --no-jrebel %* Server/clean Server/publish
