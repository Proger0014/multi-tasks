@echo off

echo push to github

./github-config.bat

git push -u origin main

echo push to gitlab

./gitlab-config.bat

git push -u origin main

echo success