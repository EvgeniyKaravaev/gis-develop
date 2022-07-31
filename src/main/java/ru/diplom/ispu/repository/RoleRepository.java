package ru.diplom.ispu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diplom.ispu.entity.Role;
import ru.diplom.ispu.entity.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    Optional<Role> findByName(RoleName roleName);

}
