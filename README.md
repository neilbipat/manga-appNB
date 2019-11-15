MANGA-APP 

A Manga Reading List using an eternal api from MangaEden.com 
MangaEden’s API  documentation - https://www.mangaeden.com/api/
•	

Technologies: 

Frontend
•	React 

Backend
•	Java
•	Docker
•	PostgresSQL

Initial ERD diagram, but later changed it to a join table. 



API & Database Structure now

Models and Table Information
•	Manga-App’s database has two main models User and Manga
•	There is a join table between User and Manga called user_mangalist where user_id and manga_title are foreign keys for all the mangas the user has now

Relationships
•	A The User and Manga tables share a many to many relationship
•	A User can have many Mangas and Mangas can have many users


Completions

•	Signup
•	Login
•	Add Mangas to Manga Table
•	Add Mangas to Users List
•	Get Mangas from Users List
•	Delete Mangas from Users List 

Available in Backend But Not used in Frontend
•	List all the Mangas in the Manga Table

Accomplishments that I am proud of
•	Able to parse data from a third party api and used it to populate the backend tables
•	Was able to use react 
Challenges
•	Learning how to parse data from a third party api to the backend
•	Learning how to use react 

User Stores
•	As a User I should be able to sign in and login so I can access the rest of the website’s features
•	As a User I should be able to look at a manga and add it to my list so I can look at the mangas I would like to read
•	As a User I should be able to delete the mangas from my list if I don’t want to have it in my list anymore









