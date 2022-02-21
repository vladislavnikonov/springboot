create table users (
    id serial primary key,
    password varchar(255),
    username varchar(255)
);

create table todos (
    id serial primary key,
    title varchar(255),
    completed boolean,
    user_id int8,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);