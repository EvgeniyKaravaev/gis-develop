package ru.diplom.ispu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.diplom.ispu.entity.Boiler;
import ru.diplom.ispu.entity.Section;
import ru.diplom.ispu.repository.BoilerRepository;

import java.util.Optional;

@Service
//@PreAuthorize("hasRole('ROLE_USER')")
public class BoilerService {

    private BoilerRepository boilerRepository;

    @Autowired
    public BoilerService(BoilerRepository boilerRepository) {
        this.boilerRepository = boilerRepository;
    }
    public Iterable<Boiler> findAllService(){
        Iterable<Boiler> boilers = boilerRepository.findAll();
        return boilers;
    }

    public Optional<Boiler> findByIdService(Long id){
        Optional<Boiler> boiler = boilerRepository.findById(id);
        return boiler;
    }

    public Boiler saveService(Boiler boiler){
        return boilerRepository.save(boiler);
    }

    public void deleteById(Long id){
        boilerRepository.deleteById(id);
    }
}
