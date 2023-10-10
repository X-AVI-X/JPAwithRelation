package assignment.jpawithrelation.service;

import assignment.jpawithrelation.entity.Department;
import assignment.jpawithrelation.repository.DepartmentRepository;
import assignment.jpawithrelation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;
    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    public Department createDepartment (Department department){
        return repository.save(department);
    }

    public Department addStudentToDepartment(Long studentId, Long departmentId){
        if (repository.existsById(departmentId)){
            if (studentRepository.existsById(studentId)){
                Department existingDepartment = repository.findById(departmentId).get();
                existingDepartment.getStudents().add(studentRepository.findById(studentId).orElse(null));
                return repository.save(existingDepartment);
            } else return null;
        }else return null;

    }

    public Department deleteStudentFromDepartment(Long studentId, Long departmentId){
        if (repository.existsById(departmentId)){
            if (studentRepository.existsById(studentId)){
                Department existingDepartment = repository.findById(departmentId).get();
                existingDepartment.getStudents()
                        .remove(studentRepository.findById(studentId).orElse(null));
                return repository.save(existingDepartment);
            } else return null;
        }else return null;

    }

    public Department updateDepartment (Department updatedDepartment){
        if (repository.existsById(updatedDepartment.getId()))
            return repository.save(updatedDepartment);
        else return null;
    }

    public List<Department> getAll (){
        return repository.findAll();
    }

    public Department getById (Long id){
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
