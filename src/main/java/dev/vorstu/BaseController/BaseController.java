package dev.vorstu.BaseController;

import dev.vorstu.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import dev.vorstu.db.repositories.StudentRepository;

import java.util.Date;

@RestController
@RequestMapping("api/base")
public class BaseController {
//    List<Student> students;
//    private Long counter = 0L;
//    private Long generateId(){return counter++;}
    @Autowired
    private StudentRepository studentrepository;
//    @PostConstruct
//    private void init(){
//        studentrepository.save(new Student("User1", "VM", "+7"));
//        studentrepository.save(new Student("User2", "VM", "+8"));
//        studentrepository.save(new Student("User3", "AM", "+99"));
//    }
//    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Student createStudent(@RequestBody Student newStudent){return addStudent(newStudent);}
//   private Student addStudent(Student student) {
//        student.setId(generateId());
//       studentrepository.save(student);
//        return student;
//   }
@PutMapping(value = "students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Student changeStudent(@RequestBody Student changingStudent){
        return updateStudent(changingStudent);
}
private Student updateStudent(Student student){
        if(student.getId()==null){
            throw new RuntimeException("id of changing student cannot be null");
        }
        studentrepository.save(student);
    /*Student changingStudent = studentrepository.save(
                .filter(el -> Objects.equals(el.getId(), student.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("student with id:" + student.getId()+ "was not found"));

        changingStudent.setFio(student.getFio());
        changingStudent.setGroup(student.getGroup());
        changingStudent.setphoneNumber(student.getphoneNumber());*/
        return student;
}
@DeleteMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Long deleteStudent(@PathVariable("id") Long id){
        return removeStudent(id);
}
private Long removeStudent(Long id){
//        students.removeIf(el -> el.getId().equals(id));
//        return id;
    studentrepository.deleteById(id);
    return id;
}
    @GetMapping("students")
    @Query("")
    public Iterable<Student> getAllStudents(){
        return studentrepository.findAll();
    }
    @GetMapping("check")
    public String greetJava(){
        return "Hello, world" + new Date();
    }
}
