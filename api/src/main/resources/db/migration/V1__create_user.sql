CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE manga (
    id SERIAL PRIMARY KEY,
    manga_title VARCHAR(100) NOT NULL,
    manga_chapter VARCHAR(100),
    manga_page VARCHAR(100)
);

CREATE TABLE user_manga (
    user_id BIGINT,
    manga_id BIGINT
);

ALTER TABLE user_manga ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE user_manga ADD CONSTRAINT fk_manga_id FOREIGN KEY (manga_id) REFERENCES manga(id);
