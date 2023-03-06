CREATE TABLE users (
  id Integer NOT NULL AUTO_INCREMENT,
  enabled varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
)