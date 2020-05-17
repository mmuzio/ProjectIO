# Projectio

Projectio is built with Spring Boot and Angular2. It uses Hibernate and Spring Data for data access operations. Hosted with AWS EC2, Postgres RDS and S3 Storage.

Run on localhost with the following steps:

1. Create jar file:
    - mvn clean install

2. Run the jar file and pass in your application properties
    - java -Dspring.application.json='{"database-name": "**1**","db-instance-identifier": "**2**","rdsPassword": "**3**","accessKey": "**4**","secretKey": "**5**"}' -jar target/SPMR-0.0.1-SNAPSHOT.jar

You can inspect the api documentation using Swagger. To do this you must:

1. Run the application using the previous steps

2. navigate to http://localhost:8080/swagger-ui.html#/

SPMR has 3 primary functionalities:

1. Create projects
    - Any user can create a project.
    - Project simply needs a description.
2. Join projects
    - User can request other users to join their project
        - User can search for other users by fields set in the user profile, such as:
            - Job title
            - Skills
            - Years of experience
    - User can request to join another users project
        - User can search for project by keyword. Keywords are set when making the project and setting its description.
3. Message teammates
    - Inside of a project, user can post messages. 
    - Messages can only be seen by other project members.
    - Messages can be either text or image.


