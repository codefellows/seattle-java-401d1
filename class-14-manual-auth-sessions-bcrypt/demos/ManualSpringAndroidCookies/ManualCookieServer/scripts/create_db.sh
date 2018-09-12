psql

# \c -- see connection
# \c tablename -- connect to table
# \l -- list all databases

# this create a database in all lowercase "javaauth"
CREATE DATABASE JavaAuth;
\connect javaauth

DROP TABLE IF EXISTS users;

# BCrypt returns password hashes of length 60, so I'm making a bit bigger.
CREATE TABLE users (
  id serial,
  username char(20),
  passhash char(80),
  bio char(150)
);
  
# add a few default users with pre-computed hashed passwords
# ugh, Postgres wants single quotes, not double quotes
INSERT INTO users(username, passhash, bio)
VALUES('moonmayor', '$2a$12$u7s.Q60pWu01Yujt6KH4wuX8Dcf9Pm1PlwEoQcGXhHrpYzRH53.Se', 'Been running this moon a long time now.'),
      ('otheruser', '$2a$12$u7s.Q60pWu01Yujt6KH4wuX8Dcf9Pm1PlwEoQcGXhHrpYzRH53.Se', 'Other person. Same password. OK!');

SELECT * FROM users;
