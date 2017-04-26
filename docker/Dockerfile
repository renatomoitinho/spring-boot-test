FROM frolvlad/alpine-oraclejdk8:slim

ENV LOG_ROOT_DIR=/var/log/
ENV ROOT_DIR=/application
ENV ROOT_DIR_CONFIG=${ROOT_DIR}/config
ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -Xmx512M -Xms128m -Xoss1024k -Xss512k -Duser.timezone=Brazil/East"

RUN mkdir $ROOT_DIR
RUN mkdir $ROOT_DIR_CONFIG

COPY application.yml ${ROOT_DIR_CONFIG}
COPY spring-boot-test*.jar ${ROOT_DIR}/app.jar

RUN sh -c 'touch ${ROOT_DIR}/app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -DLOG_ROOT_DIR=$LOG_ROOT_DIR -Dspring.profiles.active=prod -Dspring.config.location=$ROOT_DIR_CONFIG/application.yml -Djava.security.egd=file:/dev/./urandom -jar $ROOT_DIR/app.jar" ]
