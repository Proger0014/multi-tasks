@echo off

echo set config for github

"%GIT%"\git.exe config --local user.name "Iakov Kostenyuk"
"%GIT%"\git.exe config --local user.email "iakov.kostenyuk@gmail.com"

"%GIT%"\git.exe remote set-url origin https://gitlab.com/proger0014-jobtests/multi-tasks.git

echo config is installed