FROM eclipse-temurin:17-jdk
VOLUME /tmp
ARG JAR_FILE
ADD backend/target/${JAR_FILE} /app.jar
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+UseStringDeduplication"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar