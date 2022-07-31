package ru.diplom.ispu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diplom.ispu.entity.Section;
import ru.diplom.ispu.repository.SectionRepository;

import java.util.Optional;

@Service
public class SectionService {

    private SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Iterable<Section> findAllService(){
        Iterable<Section> sections = sectionRepository.findAll();
        return sections;
    }

    public Optional<Section> findByIdService(Long id){
        Optional<Section> section = sectionRepository.findById(id);
        return section;
    }

    public Section saveService(Section section){
        return sectionRepository.save(section);
    }

    public void deleteById(Long id){
        sectionRepository.deleteById(id);
    }

    public Iterable<Section> searchService(String vidTeplonositel){
        Iterable<Section> sections = sectionRepository.findByVidTeplonositel(vidTeplonositel);
        return sections;
    }


}
