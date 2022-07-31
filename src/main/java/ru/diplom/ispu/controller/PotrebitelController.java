package ru.diplom.ispu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.diplom.ispu.entity.Potrebitel;
import ru.diplom.ispu.entity.Section;
import ru.diplom.ispu.service.PotrebitelService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/potrebitel")
public class PotrebitelController {

    private PotrebitelService potrebitelService;

    @Autowired
    public PotrebitelController(PotrebitelService potrebitelService) {
        this.potrebitelService = potrebitelService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Potrebitel> findAll(){
        Iterable<Potrebitel> potrebitels = potrebitelService.findAllService();
        return potrebitels;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Potrebitel> saveController(@RequestBody Potrebitel potrebitel){
        return ResponseEntity.ok(potrebitelService.saveService(potrebitel));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Potrebitel> updateLayer(@RequestBody Potrebitel potrebitel){
        return ResponseEntity.ok(potrebitelService.saveService(potrebitel));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Potrebitel>> showIdLayer(@PathVariable Long id) {
        return ResponseEntity.ok(potrebitelService.findByIdService(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLayer(@PathVariable Long id){
        try {
            potrebitelService.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("ID " + id + " не найден!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}
