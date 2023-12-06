package dev.vorstu.db.repositories.Config;

import dev.vorstu.db.repositories.AuthUserRepo;
import dev.vorstu.db.repositories.entities.auth.AuthUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public Set<AuthUserEntity> getAllUsers() {
        return authUserRepo.findAll();
    }

    @PostMapping(value="users", produces =
            MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user) {
        return authUserRepo.save(user);
    }
}

