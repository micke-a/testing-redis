package me.mikael.testing.redis.repository;

import me.mikael.testing.redis.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
