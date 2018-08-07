FROM openjdk:8-jdk-alpine

# Refs
# https://cloud.google.com/community/tutorials/kotlin-springboot-container-engine

# Build
# docker build . --no-cache -t mlo55-fib
# docker build . -t mlo55-fib

# Run cmd
# docker run -it --rm -p 8080:8080 mlo55-fib
# docker run -d --rm -p 8080:8080 mlo55-fib
# docker exec -it <sha> sh (if the container is running)
VOLUME /tmp
RUN mkdir /work
COPY . /work
WORKDIR /work
RUN /work/gradlew build
RUN mv /work/build/libs/*.jar /work/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/work/app.jar"]


