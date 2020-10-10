# Movie_Springboot

This is a spring boot application where web service endpoints returns movies details.</br>
There are mainly 2 endpoints : 1 for all movies(by 20) and 1 for a specific movie based on ID.</br>

Movie details are its title, overview, poster(reference by path), vote average and release date.</br>

API used for data are from themoviedb. Dependency was added to use the API passing the API key generated.</br>
The API has available methods in which you can use to retrieve movies based on the desired criteria.</br>

When calling the web service endpoint it goes first to the controller.
Then it goes to the service layer where the API is called.
The retrieved data will then be mapped to DTO which will returned by the controller and data can be seen in a form of JSON(i.e using Postman).</br>

Unit testing done was through JUnit.</br>

Additionals:</br>
- 2 endpoints where data comes from database. 1 is to get all movies in DB and the other one is to get a movie with a specific ID.
- Database used was MS SQL.
- Interaction with the database was done through Spring JPA and JDBC.
