package ru.diplom.ispu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diplom.ispu.entity.Potrebitel;

@Repository
public interface PotrebitelRepository extends JpaRepository<Potrebitel,Long> {


}
