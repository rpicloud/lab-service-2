# Using rpi image with java 8
FROM hypriot/rpi-java

# Build number hard-coded so far
COPY target/deployable-application.jar /data/

EXPOSE 9002
CMD ["java", "-jar", "deployable-application.jar"]
