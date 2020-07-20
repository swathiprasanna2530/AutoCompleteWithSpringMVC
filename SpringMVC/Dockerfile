FROM tomcat:8.0.20-jre8
ADD /target/springdocker.war springdocker.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/springdocker.war"]