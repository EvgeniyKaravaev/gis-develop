package ru.diplom.ispu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.diplom.ispu.entity.Section;
import ru.diplom.ispu.service.SectionService;

import java.util.Optional;


@RestController
@RequestMapping("/api/auth/section")
public class SectionController {

    private SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Section> findAll(){
        Iterable<Section> sections = sectionService.findAllService();
        return sections;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Section> save(@RequestBody Section section){
        return ResponseEntity.ok(sectionService.saveService(section));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Section> update(@RequestBody Section section){
        return ResponseEntity.ok(sectionService.saveService(section));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Section>> showId(@PathVariable Long id) {
        return ResponseEntity.ok(sectionService.findByIdService(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        try {
            sectionService.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("ID " + id + " не найден!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<Section> search(@RequestParam String vidTeplonositel){
        Iterable<Section> sections = sectionService.searchService(vidTeplonositel);
        return sections;
    }


}
