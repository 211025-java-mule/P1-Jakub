# P1-Jakub
An application that is an extension to Project 0 (Movie Selector). It retrieves the user's movie list from P0. It then translates the plot of each movie using DeepL API. 
Then checks if the movies are available on the Netflix platform using the WatchMode API.
The features it adds are:
- Translation of movies' plot into Polish
- Checking if a movie is available on the Netflix platform
- Saving the modified movie list to a database
- Providing modified list of movies in JSON format

# Running
Setup DB (postgreSQL on docker)
> docker run -it --rm -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres --name postgres -v $(pwd)/schema.sql:/docker-entrypoint-initdb.d/schema.sql postgres

Run
> mvn exec:java

# Technologies
- Maven
- DeepL API
- WatchMode API  
- Spring
- postgreSQL and Docker
- Embedded Tomcat
- Junit
- Logback