# Auth Chassi

## Technologies:

>Java 17

> SpringBoot 3.0.2

> Spring Security 6

> Flyway 9.15.1

> Json Web Token

## Installation:

Maven installed is required (apt-get install maven)

1. `mvn install` for install dependencies
2. `mvn spring-boot:run` for run application
3. Acess the url: [http://localhost:8081](http://localhost:8081)


## Description 

This app was made to study Spring's new security implementation
(version 6), you can access some routes like login, find user by id.
This application is just a security test, its purpose is an integration
with complex systems.

## Some Routes 

~~~route
description: description: login if user exists in database this user is added for migration. (standard).
role: MANAGE_USERS
type: POST
URL: localhost:8081/api/auth/token
body: 
{
	"username": "bavand",
	"password": "12345"
}
response:
{
	"user": "bavand",
	"token": "eyJraWQiOiJkM2MzMDRjNS05N2UyLTQ3MzEtOGVkNi00MjZiMjZjNTZiZjkiLCJhbGciOiJSUzI1NiJ9...",
	"authorities": "USERS_TEST MANAGE_USERS",
	"expiration": "2023-03-06T06:03:04.728076817Z"
}
~~~

~~~route
description: description: this route find a user by id.
role: MANAGE_USERS
type: GET
URL: localhost:8081/api/users/1
reponse: 
{
	"name": "bavand",
	"username": "bavand",
	"enabled": "ACTIVE",
	"roles": [
		"USERS_TEST",
		"MANAGE_USERS"
	]
}
~~~

~~~route
description: description: this route return "HELLO {athenticated user}", made for tests;
role: USERS_TEST
type: GET
URL: localhost:8081/api/hello
reponse: "HELLO bavand"
~~~

All records mentioned above are inserted by migration defined when creating the app,
to use new records just insert by migrations versioning or by API request. In addition to the aforementioned routes,
there are others, just look in the controller folders.
 
