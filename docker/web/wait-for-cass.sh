#!/bin/bash

echo "Dummy 1 min wait"
sleep 60
exec java -jar -Dspring.profiles.active=docker /usr/shortener.jar
