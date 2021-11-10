FROM java:8
EXPOSE 8089
ADD /target/timesheet-1.0.war Timesheet.war
ENTRYPOINT ["java","-jar","Timesheet.war"]