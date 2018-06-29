-- run this script with
-- psql -f resetdb.sql javaauth

-- useful psql commands:
-- \c see connection
-- \l list all tables
-- \connect tablename
-- Postgres converts all tablenames to lowercase.
-- Postgres seems to want singlequoted strings, never doublequoted.

\x auto
\pset format wrapped

DROP DATABASE IF EXISTS  javaauth;
CREATE DATABASE javaauth;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id serial,
  username text,
  passhash text,
  bio text
);
  
INSERT INTO users(username, passhash, bio)
VALUES('moonmayor', '$2a$12$u7s.Q60pWu01Yujt6KH4wuX8Dcf9Pm1PlwEoQcGXhHrpYzRH53.Se', 'Been running this moon a long time now.'),
      ('otheruser', '$2a$12$u7s.Q60pWu01Yujt6KH4wuX8Dcf9Pm1PlwEoQcGXhHrpYzRH53.Se', 'Other person. Same password. OK!');

SELECT * FROM users;
