package dev.vorstu.db.repositories;

import dev.vorstu.dto.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
}
