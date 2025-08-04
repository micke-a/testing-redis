
Simple testing project to look at how it is to work with Redis via Spring boot


# What does this poc do?

At start-up it also starts up a redis instance via `docker compose`.

Create a student, see `app.http`
```http request
POST http://localhost:8080/api/student
```
* Sends a message on `test-messages` with the students name
* Creates the student in the Redis database
* Message is received by `Receiver` class which prints it and increments a messages received counter



# Useful information

## Links

* https://www.baeldung.com/java-redis-lettuce
* https://www.baeldung.com/jedis-java-redis-client-library
* https://howtodoinjava.com/spring-data/spring-boot-redis-with-lettuce-jedis/
* https://www.baeldung.com/spring-data-redis-properties
* https://spring.io/guides/gs/messaging-redis


## Messaging

https://spring.io/guides/gs/messaging-redis
https://docs.spring.io/spring-data/redis/reference/redis/pubsub.html
