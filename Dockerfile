FROM adoptopenjdk:11-jdk-hotspot
EXPOSE 8080
WORKDIR /application/weather
ADD . /application/weather
RUN apt-get update \
 && DEBIAN_FRONTEND=noninteractive \
    apt-get install --no-install-recommends --assume-yes \
      postgresql-client
RUN apt-get -y install maven
ARG SECRET
ENV APP_SECRET=$SECRET
ENTRYPOINT ["/application/weather/docker-entrypoint.sh"]
