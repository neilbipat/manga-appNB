CREATE TABLE mangas (
    id SERIAL,
    title VARCHAR(100)
);

CREATE TABLE users (
    id SERIAL,
    username VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE user_mangalist (
    user_id SERIAL,
    manga_id SERIAL
);