package ru.diplom.ispu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diplom.ispu.entity.Potrebitel;
import ru.diplom.ispu.entity.Section;
import ru.diplom.ispu.repository.PotrebitelRepository;

import java.util.Optional;

@Service
public class PotrebitelService {

    private PotrebitelRepository potrebitelRepository;

    @Autowired
    public PotrebitelService(PotrebitelRepository potrebitelRepository) {
        this.potrebitelRepository = potrebitelRepository;
    }

    public Iterable<Potrebitel> findAllService(){
        Iterable<Potrebitel> potrebitels = potrebitelRepository.findAll();
        return potrebitels;
    }

    public Optional<Potrebitel> findByIdService(Long id){
        Optional<Potrebitel> potrebitel = potrebitelRepository.findById(id);
        return potrebitel;
    }

    public Potrebitel saveService(Potrebitel potrebitel){
        return potrebitelRepository.save(potrebitel);
    }

    public void deleteById(Long id){
        potrebitelRepository.deleteById(id);
    }
}
