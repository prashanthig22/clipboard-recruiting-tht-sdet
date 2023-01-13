FROM maven:3.8.7
COPY src home/clipboard-recruiting-tht-sdet/src
COPY pom.xml home/clipboard-recruiting-tht-sdet/pom.xml
WORKDIR home/clipboard-recruiting-tht-sdet
ENTRYPOINT mvn clean test