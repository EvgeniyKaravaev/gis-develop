package ru.diplom.ispu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diplom.ispu.entity.ThermalCameraAssembly;

@Repository
public interface ThermalCameraAssemblyRepository extends JpaRepository<ThermalCameraAssembly,Long> {

}
