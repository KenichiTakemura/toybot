ARG JDK_VER=11
ARG MAVEN_VER=3.8.4

FROM maven:${MAVEN_VER}-jdk-${JDK_VER}
RUN apt-get update

ENV env_maven_opt="-Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn -B -q"
WORKDIR /
ADD . /toybot
WORKDIR /toybot
RUN mvn clean install ${env_maven_opt}
CMD cat src/test/resources/sample_input2.txt | mvn exec:java ${env_maven_opt}
