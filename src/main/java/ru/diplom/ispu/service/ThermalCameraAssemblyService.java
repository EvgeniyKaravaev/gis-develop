package ru.diplom.ispu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diplom.ispu.entity.ThermalCameraAssembly;
import ru.diplom.ispu.repository.ThermalCameraAssemblyRepository;

import java.util.Optional;

@Service
public class ThermalCameraAssemblyService {

    private ThermalCameraAssemblyRepository thermalCameraAssemblyRepository;

    @Autowired
    public ThermalCameraAssemblyService(ThermalCameraAssemblyRepository thermalCameraAssemblyRepository) {
        this.thermalCameraAssemblyRepository = thermalCameraAssemblyRepository;
    }

    public Iterable<ThermalCameraAssembly> findAllService(){
        Iterable<ThermalCameraAssembly> thermalCameraAssemblyIterable = thermalCameraAssemblyRepository.findAll();
        return thermalCameraAssemblyIterable;
    }

    public Optional<ThermalCameraAssembly> findByIdService(Long id){
        Optional<ThermalCameraAssembly> thermalCameraAssembly = thermalCameraAssemblyRepository.findById(id);
        return thermalCameraAssembly;
    }

    public ThermalCameraAssembly saveService(ThermalCameraAssembly thermalCameraAssembly){
        return thermalCameraAssemblyRepository.save(thermalCameraAssembly);
    }

    public void deleteById(Long id){
        thermalCameraAssemblyRepository.deleteById(id);
    }

}
