package dev.vorstu.db.repositories;

import dev.vorstu.db.repositories.entities.auth.AuthUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface AuthUserRepo extends CrudRepository<AuthUserEntity, Long> {
public Set<AuthUserEntity> findAll();
}
