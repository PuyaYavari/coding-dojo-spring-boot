#!/bin/sh

export PGPASSWORD='docker'

until psql -h db -U "docker" -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

psql -h db -U "docker" -c "CREATE USER \"docker\""
psql -h db -U "docker" -c "CREATE DATABASE \"Weather\""
psql -h db -U "docker" -c "GRANT ALL PRIVILEGES ON DATABASE \"Weather\" TO \"docker\""

mvn clean package -Dmaven.test.skip

java -jar "/application/weather/target/coding-dojo-spring-boot-1.0.0.jar"