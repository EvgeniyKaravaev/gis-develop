package ru.diplom.ispu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.diplom.ispu.entity.Boiler;
import ru.diplom.ispu.service.BoilerService;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/boiler/")
public class BoilerController {

    private BoilerService boilerService;

    @Autowired
    public BoilerController(BoilerService boilerService) {
        this.boilerService = boilerService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public Iterable<Boiler> findAll(){
        Iterable<Boiler> boilers = boilerService.findAllService();
        return boilers;
    }

//    @PreAuthorize("hasRole('USER')")
//    @Secured("ROLE_ADMIN")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Boiler> saveController(@RequestBody Boiler boiler){
        Boiler result = boilerService.saveService(boiler);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateController(@RequestBody Boiler boiler){
        if(boiler.getId() == null && boiler.getId() == 0){
            return new ResponseEntity<>("нет id",HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(boilerService.saveService(boiler));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Boiler>> showIdLayer(@PathVariable Long id) {
        return ResponseEntity.ok(boilerService.findByIdService(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLayer(@PathVariable Long id){
        try {
            boilerService.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("ID " + id + " не найден!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
