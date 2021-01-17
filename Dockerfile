FROM java:8
WORKDIR /
RUN echo "Asia/Colombo" | tee /etc/timezone
RUN dpkg-reconfigure --frontend noninteractive tzdata
ADD exam-0.0.1-SNAPSHOT.jar exam-0.0.1-SNAPSHOT.jar
EXPOSE 5050
ENTRYPOINT ["java","-jar","exam-0.0.1-SNAPSHOT.jar", "--server.servlet.context-path=/dp", "--server.port=5050"]
