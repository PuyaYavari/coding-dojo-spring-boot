#!/bin/sh

export PGPASSWORD=$POSTGRES_PASSWORD

until psql -h db -U $POSTGRES_USER -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

psql -h db -U $POSTGRES_USER -c "CREATE DATABASE \"Weather\""
psql -h db -U $POSTGRES_USER -c "GRANT ALL PRIVILEGES ON DATABASE \"Weather\" TO $POSTGRES_USER"

mvn clean package

java -jar "/application/weather/target/coding-dojo-spring-boot-1.0.0.jar"