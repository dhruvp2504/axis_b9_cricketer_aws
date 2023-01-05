FROM openjdk:8

#Adding and renaming the Jar file
ADD /target/springbootdemo-0.1.jar crickeapp.jar

#Expose Port 8080 for hitting rest end points
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cricketapp.jar"]