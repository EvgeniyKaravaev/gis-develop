package ru.diplom.ispu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.diplom.ispu.entity.ThermalCameraAssembly;
import ru.diplom.ispu.service.ThermalCameraAssemblyService;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/termCamera/")
public class ThermalCameraAssemblyController {

    private ThermalCameraAssemblyService thermalCameraAssemblyService;

    @Autowired
    public ThermalCameraAssemblyController(ThermalCameraAssemblyService thermalCameraAssemblyService) {
        this.thermalCameraAssemblyService = thermalCameraAssemblyService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public Iterable<ThermalCameraAssembly> findAll(){
        Iterable<ThermalCameraAssembly> thermalCameraAssemblyIterable = thermalCameraAssemblyService.findAllService();
        return thermalCameraAssemblyIterable;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<ThermalCameraAssembly> save(@RequestBody ThermalCameraAssembly thermalCameraAssembly){
        return ResponseEntity.ok(thermalCameraAssemblyService.saveService(thermalCameraAssembly));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<ThermalCameraAssembly> update(@RequestBody ThermalCameraAssembly thermalCameraAssembly){
        return ResponseEntity.ok(thermalCameraAssemblyService.saveService(thermalCameraAssembly));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<ThermalCameraAssembly>> showId(@PathVariable Long id) {
        return ResponseEntity.ok(thermalCameraAssemblyService.findByIdService(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        try {
            thermalCameraAssemblyService.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("ID " + id + " не найден!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
