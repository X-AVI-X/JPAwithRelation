package assignment.jpawithrelation.controller;

import assignment.jpawithrelation.entity.Department;
import assignment.jpawithrelation.entity.Student;
import assignment.jpawithrelation.service.DepartmentService;
import assignment.jpawithrelation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/academy")
public class StudentController {
    private final DepartmentService departmentService;
    private final StudentService studentService;


    public StudentController(DepartmentService departmentService, StudentService studentService) {
        this.departmentService = departmentService;
        this.studentService = studentService;
    }

    @PostMapping("/create/student")
    public ResponseEntity<?> addStudent (@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PostMapping("/create/department")
    public ResponseEntity<?> addDepartment (@RequestBody Department department){
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PostMapping("/department/{deptId}/add/student/{stuId}")

    public ResponseEntity<?> addStudentToDepartment(@PathVariable Long stuId,
                                                    @PathVariable Long deptId){
        Department department = departmentService.addStudentToDepartment(stuId, deptId);
        if (department != null)
            return new ResponseEntity<>(department, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/department/{deptId}/remove/student/{stuId}")
    public ResponseEntity<?> deleteStudentToDepartment(@PathVariable Long stuId,
                                                    @PathVariable Long deptId){
        Department department = departmentService.deleteStudentFromDepartment(stuId, deptId);
        if (department != null)
            return new ResponseEntity<>(department, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/student")
    public ResponseEntity<?> updateStudent (@RequestBody Student student){
    Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent== null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @PutMapping("/update/department")
    public ResponseEntity<?> updateDepartment (@RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartment(department);
        if (updatedDepartment== null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<?> deleteStudent (@PathVariable Long id){
        if (studentService.deleteById(id))
            return new ResponseEntity<>("Deleted.", HttpStatus.OK);
        else return new ResponseEntity<>("Doesn't exist!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/department/{id}")
    public ResponseEntity<?> deleteDept (@PathVariable Long id){
        if (departmentService.deleteById(id))
            return new ResponseEntity<>("Deleted.", HttpStatus.OK);
        else return new ResponseEntity<>("Doesn't exist!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get/student/all")
    public ResponseEntity<?> getAllStudent (){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/department/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get/department/all")
    public ResponseEntity<?> getAllDepartment (){
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

}
