package assignment.jpawithrelation.repository;

import assignment.jpawithrelation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
