FROM frolvlad/alpine-oraclejdk8:slim

ENV ROOT_DIR=/application
ENV ROOT_DIR_CONFIG=${ROOT_DIR}/config
ENV JAVA_OPTS=""

RUN mkdir $ROOT_DIR
RUN mkdir $ROOT_DIR_CONFIG

COPY application.yml ${ROOT_DIR_CONFIG}
COPY spring-boot-test-0.1.0.jar ${ROOT_DIR}/app.jar

RUN sh -c 'touch ${ROOT_DIR}/app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=default -Dspring.config.location=$ROOT_DIR_CONFIG/application.yml -Djava.security.egd=file:/dev/./urandom -jar $ROOT_DIR/app.jar" ]
