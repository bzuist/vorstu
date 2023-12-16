package dev.vorstu;

import dev.vorstu.db.repositories.AuthUserRepo;
import dev.vorstu.db.repositories.entities.auth.AuthUserEntity;
import dev.vorstu.db.repositories.entities.auth.BaseRole;
import dev.vorstu.db.repositories.entities.auth.RoleUserEntity;
import dev.vorstu.dto.Student;
import dev.vorstu.db.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initializer {

    @Autowired
    private StudentRepository studentRepository;

//    public void initial(){
//        studentRepository.save(new Student("fio", "def_group", "+79"));
//        studentRepository.save(new Student("abc", "def_group", "+7"));
//        studentRepository.save(new Student("knj2", "df_group", "+9"));
//        studentRepository.save(new Student("knj3", "df_group", "+9"));
//        studentRepository.save(new Student("knj4", "df_group", "+9"));
//        studentRepository.save(new Student("knj5", "df_group", "+9"));
//        studentRepository.save(new Student("knj6", "df_group", "+9"));
//
//    }
    @Autowired
    private AuthUserRepo authUserRepo;

    public void initial() {

        AuthUserEntity admin = new AuthUserEntity(true, "admin", "1234",
                Collections.singleton(new RoleUserEntity("admin", BaseRole.SUPER_USER))
        );

        authUserRepo.save(admin);

        AuthUserEntity student = new AuthUserEntity(true, "student", "123456",
                Collections.singleton(new RoleUserEntity("student", BaseRole.STUDENT))
        );

        authUserRepo.save(student);

        AuthUserEntity teacher = new AuthUserEntity(true, "teacher", "12345678",
                Collections.singleton(new RoleUserEntity("teacher", BaseRole.TEACHER))
        );

        authUserRepo.save(teacher);

    }
}

