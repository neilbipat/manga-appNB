# MANGA-APP 

### A Manga Reading List using an external api from MangaEden.com 

 MangaEden’s API  documentation - https://www.mangaeden.com/api/

-------------------------------------------------------------------------------------------------------------------------------------

### Technologies

#### Frontend
- React.js 
    - npm create react-app appName
    - npm install --save styled-components

#### Backend
- Docker
- PostgresSQL
- MicroServices(Recommondation) - Use Spring Initiliazer website to create your apps with the dependencies listed. 

Spring Initiliazer Website - https://start.spring.io/

- Java(Apps)
    - eureka-server(dependencies)
        - spring cloud starter netflix eureka server
        - spring boot starter test

    - zuul-gateway(dependencies)
        - spring cloud starter netflix eureka client
        - spring cloud starter netflix zuul
        - spring boot starter test
        - junit vintage engine

    My appName is called mangav2, you can give yours whatever name you like
    - appName(dependencies)
        - spring boot starter data jdbc
        - spring boot starter data jpa
        - spring boot starter data rest
        - spring boot starter security
        - spring boot starter web
        - spring boot devtools
        - postgresql
        - jjwt
        - spring cloud starter netflix eureka client
        - flyway core
        - spring security test
  
### Notes

    Make sure you have a docker-compose.yml file that is global to all of yours backend apps, like how my file structure looks like when you first come to the repository. Also make sure after creating your apps, the structure on the yml file is the same as I would have it. 

-------------------------------------------------------------------------------------------------------------------------------------

### API & Database 

#### Models and Table Information
-	mangav2's database has two main models User and Manga

-	There is a join table between User and Manga called user_mangalist where user_id and manga_title are foreign keys for all mangas the user currently has

#### Relationships
-	A The User and Manga tables share a many to many relationship
-	A User can have many Mangas and Mangas can have many users

-------------------------------------------------------------------------------------------------------------------------------------

#### Completions

-   Signup
-	Login
-	Add Mangas to Manga Table
-	Add Mangas to Users List
-	Get Mangas from Users List
-	Delete Mangas from Users List 

#### Available in Backend But Not used in Frontend
-	List all the Mangas in the Manga Table

-------------------------------------------------------------------------------------------------------------------------------------

### Accomplishments that I am proud of
-	Able to parse data from a third party api and used it to populate the backend tables
-	Was able to use react 
-	Learned how to parse data from a third party api to the backend
-   Learned how to use react 

-------------------------------------------------------------------------------------------------------------------------------------

### User Stores
-	As a User I should be able to sign in and login so I can access the rest of the website’s features
-	As a User I should be able to look at a manga and add it to my list so I can look at the mangas I would like to read
-	As a User I should be able to delete the mangas from my list if I don’t want to have it in my list anymore

-------------------------------------------------------------------------------------------------------------------------------------

### How the app works
- Take data from manga eden's api and parse it to the backend 
- Show the list on the front end with the title and a link to the actual manga website
- A user can sign up or log in and choose a manga they like and add it to their list
- A user can show their list which also has the title and link to the actual website
- If the list is shown and a user adds a manga, the user just has to press the show button and the list will update
- A user can also delete a manga from their website
