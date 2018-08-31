# Sample REST Webservice using Spring Boot
Sample application that demonstrate REST webservices using Spring Boot, Spring Caching and JDBC using MYSQL as database.
Also, demonstrate Caching functionality, where I deliberately delayed the GET process for 2 seconds for the first GET request. Next time whenever a GET request is issued response will be returned through cache, reducing the response time.

Follow these steps to execute it locally:
1. Set up a database using MySql and create a schema and named it whatever you like. Update the same in application.properties.
2. Run the application by executing the main class RestSampleApplication.java
3. Through postman invoke http://localhost:8080/employee/1
