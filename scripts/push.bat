@echo off

set path=%~dp0

echo push to github

CALL %path%\github-config.bat

"%GIT%"\git.exe push -u origin main

echo push to gitlab

CALL %path%\gitlab-config.bat

"%GIT%"\git.exe push -u origin main

echo success