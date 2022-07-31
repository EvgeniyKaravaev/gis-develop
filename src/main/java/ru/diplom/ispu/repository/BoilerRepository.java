package ru.diplom.ispu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diplom.ispu.entity.Boiler;

@Repository
public interface BoilerRepository extends JpaRepository<Boiler,Long> {


}
