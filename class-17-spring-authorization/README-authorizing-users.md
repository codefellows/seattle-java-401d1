# ![CF](http://i.imgur.com/7v5ASc8.png) Java Persistance API (JPA)

## Resources

### Guides
* [Spring Postgres Repository Guide](https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/)
* [Spring Data Repositories](http://www.baeldung.com/spring-data-repositories)
* [The DAO Pattern in Java](http://www.baeldung.com/java-dao-pattern)

### Reference
* [JavaX Validation Constraints](https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html)
* [JPA: Java Persistance API](https://spring.io/guides/gs/accessing-data-jpa/)

Ignore the `AuditModel` in the Postgres Repository Guide reading. The
AuditModel is a superclass that adds date created and date updated tables
to columns in the database.

Do make sure to look at the `src/main/java/resources/application.properties`
file configuration for Postgres in the Postgres Repository Guide reading.

Read how Java uses the DAO pattern to make simple classes to store specific
objects that will be saved in databases. Simple objects can be mapped to one
Dao interface that defines common CRUD operations:

the Dao interface is generic so it provides one certain way to interact with
any object that implements the Dao interface.

```
public interface Dao<T> {
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
```
