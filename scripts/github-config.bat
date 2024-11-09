@echo off

echo set config for github

"%GIT%"\git.exe config --local user.name "proger0014"
"%GIT%"\git.exe config --local user.email "iakov56@yandex.ru"

"%GIT%"\git.exe remote set-url origin https://github.com/Proger0014/multi-tasks.git

echo config is installed