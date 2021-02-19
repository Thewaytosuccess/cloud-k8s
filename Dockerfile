FROM hub.c.163.com/library/openjdk:8-jdk-alpine
COPY ./target/cloud-k8s.jar /cloud-k8s.jar
ENTRYPOINT ["java","-jar","/cloud-k8s.jar"]