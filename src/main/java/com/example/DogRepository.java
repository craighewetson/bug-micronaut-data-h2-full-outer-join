package com.example;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Join.Type;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface DogRepository extends CrudRepository<Dog, Long> {

    @Join(value = "collar", type = Type.OUTER)
    Optional<Dog> findById(Long id);
}
