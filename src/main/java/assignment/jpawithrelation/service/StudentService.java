package assignment.jpawithrelation.service;

import assignment.jpawithrelation.entity.Student;
import assignment.jpawithrelation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent (Student student){
        return repository.save(student);
    }

    public Student updateStudent (Student updatedStudent){
        if (repository.existsById(updatedStudent.getId()))
            return repository.save(updatedStudent);
        else return null;
    }

    public List<Student> getAll (){
        return repository.findAll();
    }

    public Student getById (Long id){
        return repository.findById(id).orElse(null);
    }

     public boolean deleteById(Long id) {
         if (repository.existsById(id)) {
             repository.deleteById(id);
             return true;
         }
         else return false;
     }
}
